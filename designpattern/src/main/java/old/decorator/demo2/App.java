package old.decorator.demo2;

public class App {

    public static void main(String[] args) {
        Saiyan saiyan = new SuperSaiyan2(new SuperSaiyan1());
        saiyan.attack();
    }
}
