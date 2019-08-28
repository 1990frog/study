package proxy.staticproxy.demo3;

public class App {

    public static void main(String[] args){
        // 首先是原始类,也就是被代理类;
        Worker worker = new Seller();
        worker.sell();
        System.out.println("-----------------------");
        // 其次是代理类,传入被代理类对象;
        Worker pw = new Scalper(worker);
        pw.sell();
    }

}
