package learn_threadsafe.iteration;

import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Vector;

/**
 * @author 
 * @title: ForAndIterator
 * @description: TODO
 * @date 2020/4/15 10:52
 */
public class ForAndIterator {

    // foreach
    private static void testForEach(Vector<Integer> vector) {
        for (Integer obj : vector) {
            if (obj.equals(3)) vector.remove(obj);
        }
    }
    // iterator
    private static void testIterator(Vector<Integer> vector) {
        Iterator<Integer> iterator = vector.iterator();
        while (iterator.hasNext()) {
            Integer v = iterator.next();
            if (v.equals(3) ) vector.remove(v);
        }
    }
    // for
    private static void testFor(Vector<Integer> vector) {
        for (int i = 0; i<vector.size();i++) {
            if (vector.get(i).equals(3))
                vector.remove(vector.get(i));
        }
    }


    @Test
    public void testFor(){
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        // 这里分别 调用 testForEach(vector);、testIterator(vector);、testFor(vector);
        testFor(vector);
        System.out.println(vector);
    }

    @Test
    public void testForeach(){
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        // 这里分别 调用 testForEach(vector);、testIterator(vector);、testFor(vector);
        testForEach(vector);
        System.out.println(vector);
    }

    @Test
    public void testIterator(){
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        // 这里分别 调用 testForEach(vector);、testIterator(vector);、testFor(vector);
        testIterator(vector);
        System.out.println(vector);
    }


}