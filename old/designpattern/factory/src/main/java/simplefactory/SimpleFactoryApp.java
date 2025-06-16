package simplefactory;

public class SimpleFactoryApp {
    public static void main(String[] args) {
        AbstractHumanFactory humanFactory = new HumanFactory();
        Human british = humanFactory.createHuman(British.class);
        british.getNationality();
        british.talk();
        Human chinese = humanFactory.createHuman(Chinese.class);
        chinese.getNationality();
        chinese.talk();
    }
}
