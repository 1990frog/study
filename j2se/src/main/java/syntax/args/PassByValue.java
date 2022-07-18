package syntax.args;

import org.testng.annotations.Test;

public class PassByValue {

    // 基本类型
    void foo1(int value) {
        value = 100;
    }

    @Test
    public void test1(){
        int value = 20;
        foo1(value);
        System.out.println(value);
    }

    // 没有提供改变自身方法的引用类型
    void foo2(String text){
        text = "windows";
    }
    @Test
    public void test2(){
        String value = "hello";
        foo2(value);
        System.out.println(value);
    }

    // 提供了改变自身方法的引用类型
    void foo3(StringBuilder builder){
        builder.append("4");
    }
    @Test
    public void test3(){
        StringBuilder sb = new StringBuilder("iphone");
        foo3(sb);
        System.out.println(sb.toString());
    }

    // 提供了改变自身方法的引用类型，但是不使用，而是使用赋值运算符
    void foo4(StringBuilder builder){
        builder = new StringBuilder("ipad");
    }
    @Test
    public void test4(){
        StringBuilder sb = new StringBuilder("iphone");
        foo4(sb);
        System.out.println(sb.toString());
    }
}
