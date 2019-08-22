package Generic;

import org.junit.Test;

/**
 * 泛型类，是在实例化类的时候指明泛型的具体类型
 */
public class StaticMethod {

    public static <T>T show(T one){
        return null;
    }

    @Test
    public void test1(){

//        class Demo<T>{
//            public static T one;
//            public static T show(T one){
//                return null;
//            }
//        }
//        Demo.show();
    }
    @Test
    public void test2(){

//        class Demo{
//            public static <T>T show(T one){
//                return null;
//            }
//        }
//        Demo.show();
    }

    @Test
    public void test3(){
        Object obj = new Object();
        StaticMethod.show(obj);
    }
}
