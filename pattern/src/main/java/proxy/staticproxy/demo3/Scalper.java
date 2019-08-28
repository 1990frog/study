package proxy.staticproxy.demo3;

/**
 * 黄牛类,也实现了Worker接口,也可以售票,称为"代理类"对象;
 */
public class Scalper implements Worker {
    // 私有一个被代理类的父类引用,这样做是为了适应所有的被代理类对象,只要实现了接口就好;
    private Worker worker;

    // 传入被代理类对象,这里的作用是初始化"代理类"中的"被代理类"对象;
    public Scalper(Worker worker) {
        this.worker = worker;
    }

    /**
     * 增强服务和功能;
     */
    @Override
    public void sell() {
        // 代理服务;
        worker.sell();
        // 额外服务;
        noQueue();
    }

    // 代理类本身自带功能;
    public void noQueue() {
        System.out.println("不用排队哟!!!");
    }
}
