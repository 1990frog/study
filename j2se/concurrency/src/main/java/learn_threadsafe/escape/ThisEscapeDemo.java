package learn_threadsafe.escape;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ThisEscapeDemo {

    public static void main(String[] args) {
        List<EscapeClass> list = new ArrayList<>();
        Thread thread = new Thread(() -> new EscapeClass(list, "lilei", 18));
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        EscapeClass escapeClass = list.get(0);
        System.out.println(escapeClass);
    }

}

class EscapeClass {

    private final String name;

    private final Integer age;

    public EscapeClass(List<EscapeClass> list, String name, Integer age) {
        this.name = name;
        list.add(this);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "name: " + name + ", age: " + age;
    }
}
