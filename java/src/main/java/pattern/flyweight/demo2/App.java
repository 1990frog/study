package pattern.flyweight.demo2;

public class App {

    public static void main(String[] args) {
        WebSiteFactory factory = new WebSiteFactory();

        WebSite fx = factory.getWebSiteCategory("产品展示");
        fx.use(new User("adam1"));

        WebSite fy = factory.getWebSiteCategory("产品展示");
        fy.use(new User("adam2"));

        WebSite fz = factory.getWebSiteCategory("产品展示");
        fz.use(new User("adam3"));

        WebSite fa = factory.getWebSiteCategory("博客");
        fa.use(new User("adam1"));

        WebSite fb = factory.getWebSiteCategory("博客");
        fb.use(new User("adam1"));

        WebSite fc = factory.getWebSiteCategory("博客");
        fc.use(new User("adam1"));

        System.out.println("网站分类总数为：" + factory.getWebSiteCount());
    }

}
