package basis.generic;

import org.junit.Test;
import org.mortbay.log.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericityClass {

    @Test
    public void test1(){
        List arrayList = new ArrayList();
        arrayList.add("aaaa");
        arrayList.add(100);

        for(int i = 0; i< arrayList.size();i++){
            String item = (String)arrayList.get(i);
            System.out.println("泛型测试：item = " + item);
        }
        /**
         * ArrayList可以存放任意类型，例子中添加了一个String类型，添加了一个Integer类型，
         * 再使用时都以String的方式使用，因此程序崩溃了。为了解决类似这样的问题（在编译阶段就可以解决），泛型应运而生。
         */
    }

    /**
     * 这个例子可以证明，在编译之后程序会采取去泛型化的措施。
     * 也就是说Java中的泛型，只在编译阶段有效。
     * 在编译过程中，正确检验泛型结果后，会将泛型的相关信息擦出，并且在对象进入和离开方法的边界处添加类型检查和类型转换的方法。
     * 也就是说，泛型信息不会进入到运行时阶段。
     *
     * 对此总结成一句话：泛型类型在逻辑上看以看成是多个不同的类型，实际上都是相同的基本类型。
     *
     * <p>泛型只在编译阶段有效。</p>
     *
     */
    @Test
    public void test2(){
        List<String> stringArrayList = new ArrayList<>();
        List<Integer> integerArrayList = new ArrayList<>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();

        if(classStringArrayList.equals(classIntegerArrayList)){
            Log.info("泛型测试：类型相同");
        }
    }

    /**
     * E - Element (在集合中使用，因为集合中存放的是元素)
     * T - Type（Java 类）
     * K - Key（键）
     * V - Value（值）
     * N - Number（数值类型）
     * ？- 表示不确定的java类型
     * S、U、V - 2nd、3rd、4th types
     *
     * Object跟这些标记符代表的java类型有啥区别呢？
     * Object是所有类的根类，任何类的对象都可以设置给该Object引用变量，使用的时候可能需要类型强制转换，
     * 但是用使用了泛型T、E等这些标识符后，在实际用之前类型就已经确定了，不需要再进行类型强制转换。
     */
    @Test
    public void test3(){
        //此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
        //在实例化泛型类时，必须指定T的具体类型
        class Generic<T>{
            //key这个成员变量的类型为T,T的类型由外部指定
            private T key;

            public Generic(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
                this.key = key;
            }

            public T getKey(){ //泛型方法getKey的返回值类型为T，T的类型由外部指定
                return key;
            }
        }

        //泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
        //传入的实参类型需与泛型的类型参数类型相同，即为Integer.
        Generic<Integer> genericInteger = new Generic<>(123456);

        //传入的实参类型需与泛型的类型参数类型相同，即为String.
        Generic<String> genericString = new Generic<>("key_vlaue");
        Log.info("泛型测试：key is " + genericInteger.getKey());
        Log.info("泛型测试：key is " + genericString.getKey());

    }


    /**
     *
     * 定义的泛型类，就一定要传入泛型类型实参么？并不是这样，在使用泛型的时候如果传入泛型实参，
     * 则会根据传入的泛型实参做相应的限制，此时泛型才会起到本应起到的限制作用。
     * 如果不传入泛型类型实参的话，在泛型类中使用泛型的方法或成员变量定义的类型可以为任何的类型。
     *
     * 注意：
     * 泛型的类型参数只能是类类型，不能是简单类型。
     * 不能对确切的泛型类型使用instanceof操作。如下面的操作是非法的，编译时会出错。
     * if(ex_num instanceof Generic<Number>){}
     *
     */
    @Test
    public void test4(){

        class Generic<T>{
            //key这个成员变量的类型为T,T的类型由外部指定
            private T key;

            public Generic(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
                this.key = key;
            }

            public T getKey(){ //泛型方法getKey的返回值类型为T，T的类型由外部指定
                return key;
            }
        }

        Generic<Integer> generic = new Generic("111111");
        Generic<String> generic1 = new Generic(4444);//error
        Generic generic2 = new Generic(55.55);
        Generic generic3 = new Generic(false);

        Log.info("泛型测试：key is " + generic.getKey());
        Log.info("泛型测试：key is " + generic1.getKey());
        Log.info("泛型测试：key is " + generic2.getKey());
        Log.info("泛型测试：key is " + generic3.getKey());

        if(generic instanceof  Generic){
            Log.info("instance yes");
        }

        /*if(base.copy.generic instanceof Generic<Integer>){

        }*/

    }

    /**
     * 类型擦除，单独学习
     */
    @Test
    public void test5(){

        /**
         * 方法一调用完全正常；
         * 方法二调用报错了；
         * 方法二报错的地方是在System.out.println(sort2(list).getClass());这行，
         * 而不是return list.toArray((T[]) new Comparable[list.size()]);这行；
         * 报的错是[Ljava.lang.Comparable; cannot be cast to [Ljava.lang.Integer;；
         */
        class GenericTest {
            //方法一
            public <T extends Comparable<T>> List<T> sort1(List<T> list) {
                return Arrays.asList(list.toArray((T[]) new Comparable[list.size()]));
            }
            //方法二
            public <T extends Comparable<T>> T[] sort2(List<T> list) {
                // 这里没报错
                return list.toArray((T[]) new Comparable[list.size()]);
            }
            public void main() {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(2);
                // 方法一调用正常
                System.out.println(sort1(list).getClass());
                // 方法二调用报错了，这里报错了
                System.out.println(sort2(list).getClass());
            }
        }
        GenericTest genericTest = new GenericTest();
        genericTest.main();

    }

    @Test
    public void test6(){

    }

    @Test
    public void test7(){

    }

    @Test
    public void test8(){

    }
}
