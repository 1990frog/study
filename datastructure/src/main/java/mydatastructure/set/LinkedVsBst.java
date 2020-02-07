package mydatastructure.set;

import java.util.ArrayList;

public class LinkedVsBst {

    public long cast(Set set){
        long startTime = System.currentTimeMillis();
        for(int i=0;i<10000;i++)
            set.add(i);
        long endTime = System.currentTimeMillis();
        return endTime-startTime;
    }

    public static void main(String[] args) {
        LinkedVsBst linkedVsBst = new LinkedVsBst();
        System.out.println("LinkedListSet cast "+linkedVsBst.cast(new LinkedListSet()));
        System.out.println("BSTSet cast "+linkedVsBst.cast(new BSTSet()));
    }
}
