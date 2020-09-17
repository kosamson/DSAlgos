public class Driver {
    public static void main(String[] args) {
        MyMap<Character, Integer> m = new MyMap<Character, Integer>();

        m.put('c', 1);
        m.put('a', 3);
        m.put('b', 2);

        System.out.println(m.get('c'));
        System.out.println(m.get('b'));
        System.out.println(m.get('a'));
    }
}
