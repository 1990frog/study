package factory.abstractfactory;

public abstract class AbstractChinese implements Human {

    @Override
    public void getNationality() {
        System.out.println("中国人");
    }

    @Override
    public void talk() {
        System.out.println("中国人说中文");
    }
}
