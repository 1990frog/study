package datastructure.mydatastructure.arrays;

public class App {

    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        for (int i = 0; i < 100; i++)
            array.addLast(i);
//        array.remove(98);
        System.out.println(array.getSize());
        array.set(99, 100);
        System.out.println(array.toString());
        System.out.println(array.getCapacity());
    }
}
