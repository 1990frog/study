package builder.demo4;

/**
 * 指挥者（Director）直接和客户（Client）进行需求沟通；
 * 沟通后指挥者将客户创建产品的需求划分为各个部件的建造请求（Builder）；
 * 将各个部件的建造请求委派到具体的建造者（ConcreteBuilder）；
 * 各个具体建造者负责进行产品部件的构建；
 * 最终构建成具体产品（Product）。
 */
public class Click {

    public static void showBike(Builder builder) {
        Director director = new Director(builder);
        Bike bike = director.construct();
        bike.getFrame().getFrame();
        bike.getSeat().getSeat();
        bike.getTire().getTire();
    }

    public static void main(String[] args) {
        showBike(new OfoBuilder());
        showBike(new MobikeBuilder());
    }
}
