package datastructure.mydatastructure.map;

import org.junit.Test;

public class App {

    @Test
    public void linkedListTest(){
        LinkedList<String,Integer> list = new LinkedList<>();
        list.set("hello",1);
        list.set("hello",1);
        list.set("world",1);
        System.out.println(list.toString());
    }

    @Test
    public void linkedListMap(){
        LinkedListMap<String,String> map = new LinkedListMap<>();
        map.put("hello","world");
        map.put("hello","world");
        System.out.println(map.toString());
    }

    @Test
    public void bstMap(){
        BSTMap<String,String> map = new BSTMap<>();
        map.put("hello","world");
        map.put("hello","world");
        map.put("hello1","world1");
        System.out.println(map.toString());
    }
}
