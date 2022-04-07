package mydatastructure.set;

import org.testng.annotations.Test;

public class App {

    @Test
    public void linkedListSetTest(){
        LinkedListSet<Integer> set = new LinkedListSet<Integer>(){
            {
                add(1);
                add(2);
                add(3);
            }
        };
        System.out.println(set.toString());
    }

    @Test
    public void bstSetTest(){
        BSTSet<Integer> set = new BSTSet<Integer>(){
            {
                add(1);
                add(2);
                add(3);
            }
        };
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
