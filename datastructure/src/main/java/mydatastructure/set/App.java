package mydatastructure.set;

public class App {

    public static void main(String[] args) {
        LinkedListSet<Integer> set = new LinkedListSet<>();
        set.add(1);
        set.add(3);
        set.add(2);
        System.out.println(set.toString());
    }
}
