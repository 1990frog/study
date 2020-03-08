package adapter.classadapter;

/**
 * 类适配器模式
 *
 * 角色：
 * Target（目标接口）:所要转换的所期待的接口
 * Adaptee（源角色）：需要适配的类
 * Adapter（适配器）：将源角色适配成目标接口，一般持有源接口的引用（或者继承源接口），且实现目标接口。
 *
 * 就是为了不对原有的类进行改变，所以拐了个弯
 */
public class VoltageAdapter {

    /**
     * target
     */
    interface Voltage5 {
        int output5V();
    }

    /**
     * adaptee
     */
    class Voltage220 {
        public int output220V() {
            int src = 220;
            System.out.println("我是" + src + "V");
            return src;
        }
    }

    class Mobile {
        /**
         * 充电方法
         *
         * 只支持Voltage5接口，需要将Voltage220与Voltage5建立一个适配器
         */
        public void charging(Voltage5 voltage5) {
            if (voltage5.output5V() == 5) {
                System.out.println("电压刚刚好5V，开始充电");
            } else if (voltage5.output5V() > 5) {
                System.out.println("电压超过5V，爆了！");
            }
        }
    }

    /**
     * adapter
     */
    class Adapter extends Voltage220 implements Voltage5 {
        @Override
        public int output5V() {
            int src = output220V();
            System.out.println("适配器工作开始适配电压");
            int dst = src / 44;
            System.out.println("适配完成后输出电压：" + dst);
            return dst;
        }
    }

    public void run(){
        Mobile mobile = new Mobile();
        mobile.charging(new Adapter());
    }

    public static void main(String[] args) {
        new VoltageAdapter().run();
    }

}
