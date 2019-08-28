package proxy.staticproxy.demo3;

/**
 * 售票员类,实现了Worker接口,可以进行售票,也就是"被代理类"对象;
 */
public class Seller implements Worker {
    @Override
    public void sell() {
        System.out.println("成功把票卖出去了!");
    }
}
