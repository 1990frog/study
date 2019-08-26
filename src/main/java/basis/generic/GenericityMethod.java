package basis.generic;

import org.junit.Test;
import org.mortbay.log.Log;

/**
 * 在实例化泛型类时，必须指定T的具体类型
 * 因为静态方法和静态变量属于类所有，而泛型类中的泛型参数的实例化是在创建泛型类型对象时指定的，所以如果不创建对象，根本无法确定参数类型。
 * 但是静态泛型方法是可以使用的，我们前面说过，泛型方法里面的那个类型和泛型类那个类型完全是两回事。
 *
 *
 * 泛型类，是在实例化类的时候指明泛型的具体类型；
 * 泛型方法，是在调用方法的时候指明泛型的具体类型 。
 *
 * 静态方法无法访问类上定义的泛型；如果静态方法操作的引用数据类型不确定的时候，必须要将泛型定义在方法上。
 *
 * 泛型方法能使方法独立于类而产生变化，以下是一个基本的指导原则：
 * 无论何时，如果你能做到，你就该尽量使用泛型方法。也就是说，如果使用泛型方法将整个类泛型化，那么就应该使用泛型方法。
 * 另外对于一个static的方法而已，无法访问泛型类型的参数。所以如果static方法要使用泛型能力，就必须使其成为泛型方法。
 *
 */
public class GenericityMethod<T> {

    //这个类是个泛型类，在上面已经介绍过
    public class Generic<T>{
        private T key;

        public Generic(T key) {
            this.key = key;
        }

        //我想说的其实是这个，虽然在方法中使用了泛型，但是这并不是一个泛型方法。
        //这只是类中一个普通的成员方法，只不过他的返回值是在声明泛型类已经声明过的泛型。
        //所以在这个方法中才可以继续使用 T 这个泛型。
        public T getKey(){
            return key;
        }

        /**
         * 这个方法显然是有问题的，在编译器会给我们提示这样的错误信息"cannot reslove symbol E"
         * 因为在类的声明中并未声明泛型E，所以在使用E做形参和返回值类型时，编译器会无法识别。
         public E setKey(E key){
         this.key = keu
         }
         */
    }

    /**
     * 这才是一个真正的泛型方法。
     * 首先在public与返回值之间的<T>必不可少，这表明这是一个泛型方法，并且声明了一个泛型T
     * 这个T可以出现在这个泛型方法的任意位置.
     * 泛型的数量也可以为任意多个
     *    如：public <T,K> K showKeyName(Generic<T> container){
     *        ...
     *        }
     */

    public <T> T showKeyName(Generic<T> container){
        System.out.println("container key :" + container.getKey());
        //当然这个例子举的不太合适，只是为了说明泛型方法的特性。
        T test = container.getKey();
        return test;
    }

    //这也不是一个泛型方法，这就是一个普通的方法，只是使用了Generic<Number>这个泛型类做形参而已。
    public void showKeyValue1(Generic<Number> obj){
        Log.info("泛型测试 key value is " + obj.getKey());
    }

    //这也不是一个泛型方法，这也是一个普通的方法，只不过使用了泛型通配符?
    //同时这也印证了泛型通配符章节所描述的，?是一种类型实参，可以看做为Number等所有类的父类
    public void showKeyValue2(Generic<?> obj){
        Log.info("泛型测试 key value is " + obj.getKey());
    }

    /**
     * 这个方法是有问题的，编译器会为我们提示错误信息："UnKnown class 'E' "
     * 虽然我们声明了<T>,也表明了这是一个可以处理泛型的类型的泛型方法。
     * 但是只声明了泛型类型T，并未声明泛型类型E，因此编译器并不知道该如何处理E这个类型。
     public <T> T showKeyName(Generic<E> container){
     ...
     }
     */

    /**
     * 这个方法也是有问题的，编译器会为我们提示错误信息："UnKnown class 'T' "
     * 对于编译器来说T这个类型并未项目中声明过，因此编译也不知道该如何编译这个类。
     * 所以这也不是一个正确的泛型方法声明。
     public void showkey(T genericObj){

     }
     */




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

    /**
     * 此处的T是由类初始化时指定的
     */
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

//    public static  T genericMethodFour(Class<T> tClass)throws InstantiationException ,
//            IllegalAccessException{
//        T instance = tClass.newInstance();
//        return instance;
//    }

    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
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

    public <T> void printMsg( T... args){
        for(T t : args){
            Log.info("泛型测试 t is " + t);
        }
    }

    @Test
    public void test2(){
        printMsg("111",222,"aaaa","2323.4",55.55);
    }

}
