package mydatastructure.linkedlist.singly;

public class App {

    public static void main(String[] args) {
        DummyHeadLinkedList<Integer> linkedList = new DummyHeadLinkedList<>();
        for (int i = 0; i < 10; i++)
            linkedList.addLast(i);
        System.out.println(linkedList);
        linkedList.remove(3);
        System.out.println(linkedList);
        linkedList.add(3,3);
        System.out.println(linkedList);
    }

}
