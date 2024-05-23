package learn_threadsafe.iteration;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentModificationExceptionDemo {

    @Test
    public void testFor() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for (int i = 0; i < list.size(); i++) {
            if (i == 1) {
                list.remove(2);
            }
            System.out.println(list.get(i));
        }
    }

    @Test
    public void testForeach() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for (Integer val : list) {
            if (val.equals(3)) {
                list.remove(val);
            }
        }

//        for (Integer obj : list) {
//            if (obj.equals(3)) list.remove(obj);
//        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        for (Integer val : list) {
            if (val.equals(4)) {
                list.remove(val);
            }
        }
    }
}
