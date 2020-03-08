package adapter.classadapter;

public class DisplayAdapter {

    // target
    interface Dp{
        String useDp();
    }

    // adaptee
    class Hdmi{
        String useHdmi(){
            System.out.println("输出黑魂2");
            return "hdmi";
        }
    }

    class Display{
        void display(Dp dp){
            if(dp.useDp().equals("dp")){
                System.out.println("可以使用dp接口玩黑魂2了\"");
            }
        }
    }

    // adapter
    class Adapter extends Hdmi implements Dp{

        @Override
        public String useDp() {
            String hdmi = useHdmi();
            System.out.println("先获取到"+hdmi+"画面");
            System.out.println("将hdmi转换成dp了");
            return "dp";
        }
    }

    public void run(){
        Display display = new Display();
        display.display(new Adapter());
    }

    public static void main(String[] args) {
        new DisplayAdapter().run();
    }

}
