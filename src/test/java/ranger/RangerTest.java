package ranger;

/**
 * @author
 * @date 2022-01-05 11:31
 * @desc
 **/

public class RangerTest {

    public static void main(String[] args) {
        //don not to put a pair of conflict judgement, it will not check it!
        //Ranger<T extends Comparable, V>
        Ranger<Integer, Integer> ranger = new Ranger<>();
        //[0, 9] -> 1
        ranger.add(0, 9, true, true, 1);
        //[10, 99] -> 2
        ranger.add(10, 99, true, true, 2);
        //[100, 999] -> 3
        ranger.add(100, 999, true, true, 3);
        //[10000, +∞] -> 5
        ranger.add(10000, null, true, false, 5);
        //1
        System.out.println(ranger.get(3));
        //2
        System.out.println(ranger.get(33));
        //3
        System.out.println(ranger.get(333));
        //null
        System.out.println(ranger.get(3333));
        //4
        System.out.println(ranger.getOrDefault(3333, 4));
        //5
        System.out.println(ranger.get(33333));
        //null
        System.out.println(ranger.get(-1));
        //[-∞, 0) -> -1
        ranger.add(null, 0, false, false, -1);
        //-1
        System.out.println(ranger.get(-1));
    }

}
