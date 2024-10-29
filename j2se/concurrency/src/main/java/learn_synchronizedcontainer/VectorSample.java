package learn_synchronizedcontainer;

import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Random;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class VectorSample {

    static Vector<Integer> vector = new Vector<>(IntStream.range(0, 100).boxed().collect(Collectors.toList()));

    @Test
    public void testFor() {
        for (int i = 0; i < vector.size(); i++) {
            System.out.println(vector.get(i));
            vector.remove(i);
        }
    }

    @Test
    public void testIterator() {
        Iterator<Integer> iterator = vector.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            vector.add(iterator.next());
        }
    }

    @Test
    public void testHiddenIterator() {
        Random random = new Random();
//        for (int i = 0; i < vector.size(); i++) { 搞笑了
        for (int i = 0; i < 100; i++) {
            vector.add(random.nextInt(100));
        }
        System.out.println(vector);
    }

}
