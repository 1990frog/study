package factory.abstractfactory;

public class MaleFactory implements HumanFactory{
    @Override
    public Human createChinese() {
        return new ChineseMen();
    }

    @Override
    public Human createAmerican() {
        return new AmericanMen();
    }

    @Override
    public Human createBritish() {
        return new BritishMen();
    }
}
