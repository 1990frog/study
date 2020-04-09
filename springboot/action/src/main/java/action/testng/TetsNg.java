package action.testng;

import org.testng.annotations.*;

public class TetsNg {

    @BeforeMethod
    public void test1(){
        System.out.println("BeforeMethod");
    }

    @AfterMethod
    public void test2(){
        System.out.println("AfterMethod");
    }

    @BeforeClass
    public void test3(){
        System.out.println("BeforeClass");
    }

    @AfterClass
    public void test4(){
        System.out.println("AfterClass");
    }

    @BeforeSuite
    public void test5(){
        System.out.println("BeforeSuite");
    }

    @AfterSuite
    public void test6(){
        System.out.println("AfterSuite");
    }

    @Test
    public void test(){

    }
}
