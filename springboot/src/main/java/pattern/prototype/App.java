package pattern.prototype;

/**
 *
 * The Prototype pattern is a creational design pattern in software development. It is used when the
 * type of objects to create is determined by a prototypical instance, which is cloned to produce
 * new objects. This pattern is used to: - avoid subclasses of an object creator in the client
 * application, like the abstract factory pattern does. - avoid the inherent cost of creating a new
 * object in the standard way (e.g., using the 'new' keyword)
 * <p>
 * In this example we have a factory class ({@link HeroFactoryImpl}) producing objects by cloning
 * the existing ones. The factory's prototype objects are given as constructor parameters.
 *
 * Prototype模式是软件开发中的创建设计模式。 它用的时候
 * 要创建的对象类型由原型实例确定，该实例被克隆生成
 * 新物件。 此模式用于： - 避免客户端中对象创建者的子类
 * 应用程序，就像抽象工厂模式一样。  - 避免创建新的固有成本
 * 标准方式的对象（例如，使用'new'关键字）
 */
public class App {

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(String[] args) {
        HeroFactory factory;
        Mage mage;
        Warlord warlord;
        Beast beast;

        factory = new HeroFactoryImpl(new ElfMage(), new ElfWarlord(), new ElfBeast());
        mage = factory.createMage();
        warlord = factory.createWarlord();
        beast = factory.createBeast();
        System.out.println(mage);
        System.out.println(warlord);
        System.out.println(beast);

        factory = new HeroFactoryImpl(new OrcMage(), new OrcWarlord(), new OrcBeast());
        mage = factory.createMage();
        warlord = factory.createWarlord();
        beast = factory.createBeast();
        System.out.println(mage);
        System.out.println(warlord);
        System.out.println(beast);
    }
}
