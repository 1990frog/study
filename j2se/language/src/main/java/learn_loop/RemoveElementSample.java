package learn_loop;

import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RemoveElementSample {

    static List<Integer> list = IntStream.range(1, 10).boxed().collect(Collectors.toList());

    @Test
    public void testFor() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            list.remove(i);
        }
    }

    @Test
    public void testIteratorConcurrentModificationException() {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            list.remove(iterator.next());
            System.out.println(iterator.next());
        }
    }

    @Test
    public void testIterator() {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
