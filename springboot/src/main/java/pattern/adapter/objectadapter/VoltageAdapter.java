package pattern.adapter.objectadapter;

import lombok.AllArgsConstructor;
import lombok.Data;

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

    @Data
    @AllArgsConstructor
    class Adapter implements Voltage5{

        private Voltage220 voltage220;

        @Override
        public int output5V() {
            int src = voltage220.output220V();
            System.out.println("适配器工作开始适配电压");
            int dst = src / 44;
            System.out.println("适配完成后输出电压：" + dst);
            return dst;
        }
    }

    public void run(){
        Mobile mobile = new Mobile();
        mobile.charging(new Adapter(new Voltage220()));
    }

    public static void main(String[] args) {
        new VoltageAdapter().run();
    }
}
