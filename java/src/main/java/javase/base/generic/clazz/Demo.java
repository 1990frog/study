package javase.base.generic.clazz;

import org.junit.Test;

public class Demo<T> {

    public T get1(T t){//泛型类方法
        return t;
    }

    public <T> T get2(T t){//泛型方法
        return t;
    }

    public String get3(String t){
        return t;
    }

    @Test
    public void test1(){
        Demo demo1 = new Demo();
        Object obj = demo1.get1(new String());
        System.out.println(obj.getClass().toString());
        System.out.println(demo1.get2("haha").toString());
        String s = demo1.get3("haha");
        System.out.println(s);

//        Demo<String> demo2 = new Demo();
//        System.out.println(demo2.get1(123));

        Demo<Number> demo3 = new Demo<>();

        if(demo3 instanceof Demo<?>){
        }
    }


}
