package adapter.classadapter.demo4;

public class Adapter extends Adaptee implements Target{
    @Override
    public void sampleOperation2() {
        System.out.println("sampleOperation2");
    }
}