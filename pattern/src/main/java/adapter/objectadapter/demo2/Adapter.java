package adapter.objectadapter.demo2;

public class Adapter implements Target{

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void sampleOperation1() {
        //直接使用adaptee中的sampleOperation1方法
        adaptee.sampleOperation1();
    }

    @Override
    public void sampleOperation2() {
        //自己编写
        System.out.println("sampleOperation2");
    }

}

