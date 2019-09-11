package builder.demo2;

/**
 * Builder----建造者
 */
public interface RobustBuilder {
    void init();
    void buildHead(String head);
    void buildBody(String body);
    Robust getRobust();
}
