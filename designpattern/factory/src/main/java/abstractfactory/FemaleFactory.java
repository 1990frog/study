package factory.abstractfactory;

public class FemaleFactory implements HumanFactory{
    @Override
    public Human createChinese() {
        return new ChineseWomen();
    }

    @Override
    public Human createAmerican() {
        return new AmericanWomen();
    }

    @Override
    public Human createBritish() {
        return new BritishWomen();
    }
}
