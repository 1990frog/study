package gc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {

    static final String[] dict = {"aaa","bbb","ccc","ddd"};

    public static void main(String[] args) {

        Runnable runnable = () -> {
            Random random = new Random(1);
            List list1 = new ArrayList<>();
            List list2 = new ArrayList<>();
            int i = 1;
            while (true) {
                list1.add(dict[random.nextInt(4)]);
                list2.add(dict[random.nextInt(4)]);
                i++;
                if (i == 100000000) {
                    list1 = new ArrayList();
                    list2 = new ArrayList();
                    i = 0;
                }
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }

}
