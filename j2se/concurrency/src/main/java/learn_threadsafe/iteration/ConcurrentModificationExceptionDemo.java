package learn_threadsafe.iteration;

import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.List;

public class ConcurrentModificationExceptionDemo {

    private static final List<String> list = Lists.newArrayList("a", "b", "c", "d", "e", "f");

    @Test
    public void testFor() {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("c")) {
                list.remove(list.get(i));
            }
        }
    }

    /**
     * foreach
     */
    @Test
    public void testForeach() {
        for (String val : list) {
            if (val.equals("c")) {
                list.remove(val);
            }
        }
    }


}
