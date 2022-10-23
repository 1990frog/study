import org.testng.annotations.Test;

import java.util.HashMap;

public class MethodReference {

    @Test
    public void test() {
        HashMap<String, Integer> map = new HashMap<>();
        map.merge("a", 1, (count, incr) -> count + incr);
        System.out.println(map);
        map.merge("a", 1, (count, incr) -> count + incr);
        System.out.println(map);
        map.merge("a", 1, Integer::sum);
        System.out.println(map);
    }

}
