package base.copy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;

public class CopyDemo {

    @Test
    public void test1(){
        int a = 1;
        int b = a;
        System.out.println(b+"");
        a = 2;
        System.out.println(b+"");
    }

    /**
     * class Integer{
     *     private final int value;
     * }
     *
     * Integer的value是final的
     *
     * String的value也是final的
     */
    @Test
    public void test2(){
        /**
         * 直接赋值，实际上是copy指针
         * a=b时，a与b指向了同一个Integer(1)
         * a=2时，a的指针指向了Integer(2)，而b的指针未变
         */
        Integer a = 1;
        //个语句使b重新指向了一个新的地址,b = new Integer(a);
        Integer b = a;
        System.out.println(b+"");
        a = 2;
        System.out.println(b+"");
    }

    /**
     * map1=map2，copy指针
     * map2.put("a","b")，指针指向的对象数据变化，指针未变
     * 所以map1与map2对应的堆发生变化，因为对应的是同一个堆
     *
     * map2=new HashMap()时，map1的值未发生变化，是因为map2指向了新的堆
     */
    @Test
    public void test3(){
        HashMap map1 = new HashMap();
        map1.put("a","a");
        HashMap map2 = map1;
        map2.put("a","b");
        System.out.println(map1.toString());
        map2 = new HashMap();
        System.out.println(map1.toString());
    }

    /**
     * 浅拷贝
     * @throws CloneNotSupportedException
     */
    @Test
    public void test4() throws CloneNotSupportedException {

        @Getter
        @Setter
        @AllArgsConstructor
        class Entity implements Cloneable{
            private String value;
            private Entity next;
            public Entity(){
            }
            @Override
            public Entity clone() throws CloneNotSupportedException {
                return (Entity)super.clone();
            }
        }

        Entity en1 = new Entity();
        en1.setValue("1");

        Entity en2 = new Entity("2",en1);
        System.out.println("en2.next.value："+en2.next.getValue());

        Entity en3 = en2.clone();
        System.out.println("en3.next.value："+en3.next.getValue());

        en1.setValue("2");
        System.out.println("en1 value change to 2");
        System.out.println("en3.next.value："+en3.next.getValue());
    }

    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T clone(T obj){
        T cloneObj = null;
        try {
            //写入字节流
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream obs = new ObjectOutputStream(out);
            obs.writeObject(obj);
            obs.close();

            //分配内存，写入原始对象，生成新对象
            ByteArrayInputStream ios = new ByteArrayInputStream(out.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(ios);
            //返回生成的新对象
            cloneObj = (T) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cloneObj;
    }

    /**
     * 深拷贝
     * 方案一：序列化
     */
    @Test
    public void test5()  {

//        /**
//         *  序列化这样的内部类实例将导致其关联的外部类实例的序列化
//         *  内部类的序列化（即，嵌套类不属于静态成员的类），包括本地和匿名类，被强烈反对
//         *
//         *  内部类不能被序列化
//         */
//        @Getter
//        @Setter
//        @AllArgsConstructor
//        class Entity implements Cloneable,Serializable {
//            private static final long serialVersionUID = 6802841645328821581L;
//            private String value;
//            private Entity next;
//            public Entity(){
//            }
//        }

        CopyEntity en1 = new CopyEntity();
        en1.setValue("1");

        CopyEntity en2 = en1;
        System.out.println(en2.getValue());

        en1.setValue("2");
        System.out.println(en2.getValue());

        CopyEntity en3 = CopyDemo.clone(en1);
        System.out.println(en3.getValue());

        en1.setValue("3");
        System.out.println(en3.getValue());
    }

    /**
     * 序列化
     * 方案2：Json
     */
    @Test
    public void test6(){

    }
}
