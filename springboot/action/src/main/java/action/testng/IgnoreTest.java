package action.testng;

import org.testng.annotations.Test;

public class IgnoreTest {

    @Test
    public void ignoreMethod1(){
        System.out.println("ignoremethod1执行");
    }

    @Test(enabled = false)
    public void ignoreMethod2(){
        System.out.println("ignoremethod2执行");
    }

    @Test(enabled = true)
    public void ignoreMethod3(){
        System.out.println("ignoremethod3执行");
    }
}
