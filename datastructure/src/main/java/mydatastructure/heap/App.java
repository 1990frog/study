package mydatastructure.heap;

import org.testng.annotations.Test;

public class App {

    @Test
    public void arrayList(){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.addLast(i);
        }
        System.out.println(list);
    }
}
