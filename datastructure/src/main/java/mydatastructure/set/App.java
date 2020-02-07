package mydatastructure.set;

import org.junit.Test;

public class App {

    @Test
    public void linkedListSetTest(){
        LinkedListSet<Integer> set = new LinkedListSet<>();
        set.add(1);
        set.add(3);
        set.add(2);
        System.out.println(set.toString());
    }

    @Test
    public void bstSetTest(){
        BSTSet set = new BSTSet();
        set.add(1);
        set.add(3);
        set.add(2);
        System.out.println(set.toString());
    }

    @Test
    public void bstVsLinked(){
        LinkedListSet<Integer> set = new LinkedListSet<>();
//        BSTSet set = new BSTSet();
        long startTime = System.currentTimeMillis();
        for(int i=0;i<10000;i++)
            set.add(i);
        long endTime = System.currentTimeMillis();
        System.out.println("linked cast time:"+(endTime-startTime));
    }
}
