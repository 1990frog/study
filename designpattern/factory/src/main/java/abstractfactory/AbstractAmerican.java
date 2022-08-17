package factory.abstractfactory;

public abstract class AbstractAmerican implements Human {
    @Override
    public void getNationality() {
        System.out.println("美国");
    }

    @Override
    public void talk() {
        System.out.println("美国人说美式英语");
    }
}
