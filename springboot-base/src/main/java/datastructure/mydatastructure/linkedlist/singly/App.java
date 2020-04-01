package datastructure.mydatastructure.linkedlist.singly;

import org.junit.Test;

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

    @Test
    public void linkedList(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addLast(i);
        }
        for (int i = 0; i < 10; i++) {
            linkedList.addFirst(i);
        }
        linkedList.add(2, 100);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);
        linkedList.remove(0);
        linkedList.remove(1);
        linkedList.remove(2);
        System.out.println(linkedList);
    }
}
