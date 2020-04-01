package datastructure.mydatastructure.set;

import datastructure.mydatastructure.linkedlist.singly.DummyHeadLinkedList;

public class LinkedListSet<E> implements Set<E> {

    private DummyHeadLinkedList<E> list;

    public LinkedListSet(){
        list = new DummyHeadLinkedList();
    }

    @Override
    public void add(E e) {
        if(!contains(e))
            list.addFirst(e);
    }

    @Override
    public void remove(E e) {
        for(int i =0;i<list.getSize();i++){
            if(list.get(i).equals(e)){
                list.remove(i);
                break;
            }
        }
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
