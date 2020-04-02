package javase.base.exception.trycatchexception;


public class OrderAndReturn {

    /**
     * finally中存在return
     * 无论try中的代码是否触发异常，finally中的代码都会执行，如果在finally中添加了return，那么try的return不会执行
     */
    public static String test1(){
        try{
            int i = 10/1;
//            int i = 10/0;
            return "try has return";
        }catch (Exception e){
            return "catch has return";
        }finally {
            return "finally has return";
        }
    }

    /**
     * finally中不存在return，try与catch中存在return
     */
    public static String test2(){
        try{
            int i = 10/0;
            return "try has return";
        }catch (Exception e){
            return "catch has return";
        }finally {
            System.out.println("finally has run");
        }
    }

    public static String test3(){
        try{
            int i = 10/0;
            return "try has return";
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("finally has run");
        }
        return "接着运行！";
    }

    /**
     * 执行顺序：try（非return），catch（非return），finally（非return）
     * finally中return，catch中return，try中return
     */
    public static String test4(){
        try{
            System.out.println("step-1");
            int i = 10/0;
            System.out.println("step-2");
            return "try has return";
        }catch (Exception e){
            System.out.println("step-3");
//            e.printStackTrace();
            return "catch has return";
        }finally {
            System.out.println("step-4");
            return "finally has return";
        }
//        System.out.println("step-5");
//        return "接着运行！";
    }

    /**
     * 三种情况：
     * try中存在return
     * catch中存在return
     * finally中存在return
     *
     * 结论：
     * 1.如果finally存在return，那么其余的return都可以放假了
     * 2.优先执行顺序：finally——>(存在异常)catch——>try
     */
    public static void main(String[] args) {
//        System.out.println(test1());
//        System.out.println(test2());
        System.out.println(test4());
    }

}
