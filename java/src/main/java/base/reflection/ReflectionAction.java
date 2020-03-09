package base.reflection;

import org.junit.runner.manipulation.Sortable;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 *
 *
 */
public class ReflectionAction {

    /**
     * 获取类的基本信息
     */
    public void getClassInfo(Object obj){
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
    public String getClassType(Class clazz){
        if(clazz.isAnnotation())
            return "注解";
        if(clazz.isArray())
            return "数组";
        if(clazz.isEnum())
            return "枚举";
        if(clazz.isInterface())
            return "接口";
        if(clazz.isLocalClass())
            return "局部类";
        if(clazz.isMemberClass())
            return "内部类";
        return "最后都是Object类型";
    }

    /**
     * 我想获取当前类的继承栈
     */
    public List getSupperClass(Object obj){
        List ret = new ArrayList();
        Class clazz = obj.getClass();
        while (!Object.class.equals(clazz)){
            clazz = clazz.getSuperclass();
            ret.add(clazz);
        }
        return ret;
    }

    /**
     * 获取类实现的所有接口
     */
    public void getInterfaces(Object obj){
        Class<?>[] interfaces;
        interfaces = obj.getClass().getInterfaces();
        Arrays.stream(interfaces).forEach(System.out::println);
    }

    /**
     * 获取类全部方法，包含父类方法（非私有方法）
     */
    public void getClassMethod(Object obj){
        Method[] methods = obj.getClass().getMethods();
        Arrays.stream(methods).forEach(System.out::println);
    }

    /**
     * 获取当前类全部方法（包含私有方法），不包含基类方法
     */
    public void getDeclaredMethod(Object obj){
        Method[] methods = obj.getClass().getDeclaredMethods();
        Arrays.stream(methods).forEach(System.out::println);
    }

    /**
     * 加强版
     * 获取包含基类私有方法的全部方法
     *
     * 可以用递归的方法写一个
     */
    public List getALlMethod(Object obj){
        Class clazz = obj.getClass();
        List<HashMap<Object,Method[]>> list = new ArrayList<>();

        while (!Object.class.equals(clazz)){
            HashMap map = new HashMap();
            map.put(clazz,clazz.getDeclaredMethods());
            list.add(map);
            clazz = clazz.getSuperclass();
        }
        return list;
    }


    public static void main(String[] args) {
        ReflectionAction reflectionAction = new ReflectionAction();
//        List list = reflectionAction.getDeclaredMehtodPlus(new Children());
//        System.out.println(list);
        System.out.println(reflectionAction.getClassType(Sortable.class));
    }


}