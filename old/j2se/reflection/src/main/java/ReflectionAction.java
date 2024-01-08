import org.testng.annotations.Test;
import entity.Child;
import entity.Children;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @see #getClassInfo 获取类的基本信息
 * @see #getClassType 获取对象的元类型
 * @see #getSupperClass 我想获取当前类的继承栈
 * @see #getInterfaces 获取类实现的所有接口
 * @see #getClassMethod 获取类全部方法，包含父类方法（非私有方法）
 * @see #getDeclaredMethod 获取当前类全部方法（包含私有方法），不包含基类方法
 * @see #getALlMethod 获取包含基类私有方法的全部方法
 * @see #accpetPrivateMethod 通过反射访问私有方法
 * @see #getFields 获取私有属性
 * @see #constructNoParam 反射无参构造方法
 * @see #constructManyParam 反射有参构造方法
 */
public class ReflectionAction {

    /**
     * 获取类的基本信息
     */
    public void getClassInfo(Object obj) {
        Class clazz = obj.getClass();
        // 获得类的名字
        System.out.println(clazz.getSimpleName());
        // 获得类的完整路径名字
        System.out.println(clazz.getName());
        // 获得类的包
        System.out.println(clazz.getPackage());
    }

    /**
     * 获取对象的元类型
     */
    public String getClassType(Class clazz) {
        if (clazz.isAnnotation())
            return "注解";
        if (clazz.isArray())
            return "数组";
        if (clazz.isEnum())
            return "枚举";
        if (clazz.isInterface())
            return "接口";
        if (clazz.isLocalClass())
            return "局部类";
        if (clazz.isMemberClass())
            return "内部类";
        return "最后都是Object类型";
    }

    /**
     * 我想获取当前类的继承栈
     */
    public List getSupperClass(Object obj) {
        List ret = new ArrayList();
        Class clazz = obj.getClass();
        while (!Object.class.equals(clazz)) {
            clazz = clazz.getSuperclass();
            ret.add(clazz);
        }
        return ret;
    }

    /**
     * 获取类实现的所有接口
     */
    public void getInterfaces(Object obj) {
        Class<?>[] interfaces;
        interfaces = obj.getClass().getInterfaces();
        Arrays.stream(interfaces).forEach(System.out::println);
    }

    /**
     * 获取类全部方法，包含父类方法（非私有方法）
     */
    public void getClassMethod(Object obj) {
        Method[] methods = obj.getClass().getMethods();
        Arrays.stream(methods).forEach(System.out::println);
    }

    /**
     * 获取当前类全部方法（包含私有方法），不包含基类方法
     */
    public void getDeclaredMethod(Object obj) {
        Method[] methods = obj.getClass().getDeclaredMethods();
        Arrays.stream(methods).forEach(System.out::println);
    }

    /**
     * 加强版
     * 获取包含基类私有方法的全部方法
     * <p>
     * 可以用递归的方法写一个
     */
    public List getALlMethod(Object obj) {
        Class clazz = obj.getClass();
        List<HashMap<Object, Method[]>> list = new ArrayList<>();

        while (!Object.class.equals(clazz)) {
            HashMap map = new HashMap();
            map.put(clazz, clazz.getDeclaredMethods());
            list.add(map);
            clazz = clazz.getSuperclass();
        }
        return list;
    }


    /**
     * 通过反射访问私有方法
     */
    public void accpetPrivateMethod(Object obj, String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class clazz = obj.getClass();
        Method method = clazz.getDeclaredMethod(methodName);
        /**
         * 私有方法需要setAccessible(true)
         */
        method.setAccessible(true);
        /**
         * invoke(Object obj, Object... args)
         * 动态参数
         */
        method.invoke(obj);
    }

    /**
     * 获取私有方法
     *
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     */
    @Test
    public void getFields() throws IllegalAccessException, NoSuchFieldException {
        Children children = new Children();
        children.setMoney(new BigDecimal(100));
        Class clazz = children.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            /**
             * 这步是核心之一千万别忘了
             */
            field.setAccessible(true);//设置发射时取消Java的访问检查，暴力访问
            if (field.get(children) instanceof BigDecimal) {
                field.set(children, new BigDecimal(250));
                System.out.println(field.get(children));
            }
        }
    }

    @Test
    public void constructNoParam() {
        try {
            Class<?> clazz = Class.forName("javase.base.reflection.entity.Children");
            Constructor constructor = clazz.getConstructor(null);
            Children children = (Children) constructor.newInstance(null);
            System.out.println(children.getClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void constructManyParam() {
        try {
            Class<?> clazz = Class.forName("javase.base.reflection.entity.Child");
            /**
             * 参数对应构造器参数类型
             * 基础数据类型：int.class
             */
            Constructor constructor = clazz.getConstructor(String.class, int.class);
            Child children = (Child) constructor.newInstance("tom", 20);
            System.out.println(children.getName());
        } catch (Exception e) {

        }
    }


    public static void main(String[] args) {
        ReflectionAction reflectionAction = new ReflectionAction();
        try {
            reflectionAction.accpetPrivateMethod(new Children(), "privateMethod");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
