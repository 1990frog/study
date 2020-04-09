package action.testng.group.clazz;

import org.testng.annotations.Test;

@Test(groups = "classB")
public class GroupsOnClass3 {

    public void test1(){
        System.out.println("3-1");
    }

    public void test2(){
        System.out.println("3-2");
    }
}
