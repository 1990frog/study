package learn_final;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Sample2 {

    private String[] elements = new String[10];

    @Test
    public void foo() {
        elements = new String[10];
        elements[0] = "Hello";
        elements[1] = "World";
        final String[] es = elements;
        elements = new String[10];
        elements[0] = "World";
        elements[1] = "Hello";
        System.out.println(Arrays.asList(elements));
        System.out.println(Arrays.asList(es));
    }
}
