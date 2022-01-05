package ranger;

import java.util.HashMap;
import java.util.Map;

/**
 * @author neutron
 * @date 2022-01-04 18:16
 * @desc 范围检测
 **/

public class Ranger<T extends Comparable, V> {

    private class Triple {

        private Comparable<T> l;

        private Comparable<T> r;

        private boolean cl;

        private boolean cr;

        Triple(Comparable<T> l, Comparable<T> r, boolean cl, boolean cr) {
            this.l = l;
            this.r = r;
            this.cl = cl;
            this.cr = cr;
        }

        boolean in(T value) {
            int left = -1;
            if (this.l != null) {
                left = this.l.compareTo(value);
            }
            int right = 1;
            if (this.r != null) {
                right = this.r.compareTo(value);
            }
            return (left < 0 || (this.cl && left == 0)) &&
                    (right > 0 || (this.cr && right == 0));
        }

    }

    private Map<Triple, V> tripleVMap;

    public Ranger() {
        this.tripleVMap = new HashMap<>();
    }

    public V get(T value) {
        for (Map.Entry<Triple, V> entry : this.tripleVMap.entrySet()) {
            if (entry.getKey().in(value)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public V getOrDefault(T value, V def) {
        V v = get(value);
        return v == null ? def : v;
    }

    public void add(Comparable<T> l, Comparable<T> r, boolean cl, boolean cr, V value) {
        this.tripleVMap.put(new Triple(l, r, cl, cr), value);
    }

}
