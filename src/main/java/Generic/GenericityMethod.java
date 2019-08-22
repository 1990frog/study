package Generic;

import org.junit.Test;
import org.mortbay.log.Log;

public class GenericityMethod<T> {

    /**
     * 泛型方法的基本介绍
     * @param tClass 传入的泛型实参
     * @return T 返回值为T类型
     * 说明：
     *     1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     *     2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     *     3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     *     4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
     */
    public <T> T genericMethodOne(Class<T> tClass)throws InstantiationException ,
            IllegalAccessException{
        T instance = tClass.newInstance();
        return instance;
    }

    public T genericMethodTwo(Class<T> tClass)throws InstantiationException ,
            IllegalAccessException{
        T instance = tClass.newInstance();
        return instance;
    }

    public static <T> T genericMethodThree(Class<T> tClass)throws InstantiationException ,
            IllegalAccessException{
        T instance = tClass.newInstance();
        return instance;
    }

    @Test
    public void test() throws IllegalAccessException, InstantiationException {
        /**
         * 泛型方法
         */
        Object obj1 = genericMethodOne(Object.class);
        Log.info(obj1.getClass().toString());

        /**
         * 泛型类
         */
        GenericityMethod genericityMethod = new GenericityMethod();
        Object obj2 = genericityMethod.genericMethodTwo(Object.class);
        Log.info(obj2.getClass().toString());

        /**
         * 静态泛型方法（非静态类方法）
         * 能不能调用差在<T>与T的区别
         * 方法中使用T代表使用类<T>声明的泛型，此时需要类实例化，才清楚类的泛型
         */
        Object obj3 = GenericityMethod.genericMethodThree(Object.class);
        Log.info(obj3.getClass().toString());
    }

}
