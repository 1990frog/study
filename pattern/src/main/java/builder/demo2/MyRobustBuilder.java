package builder.demo2;

/**
 * ConcreateBuilder----具体创建者。
 */
public class MyRobustBuilder implements RobustBuilder {

    private Robust robust;

    public void init() {
        robust = new Robust();
    }

    public void buildHead(String head) {
        robust.setHead(head);
    }

    public void buildBody(String body) {
        robust.setBody(body);
    }

    public Robust getRobust() {
        return robust;
    }
}

