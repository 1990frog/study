package simplefactory;

public class British implements Human{
    @Override
    public void getNationality() {
        System.out.println("英国人");
    }

    @Override
    public void talk() {
        System.out.println("英国人说英语");
    }
}
