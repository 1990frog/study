package base.keyword.$default;

public class Demo<T> implements MyInterface<T> {
    private T t;

    @Override
    public void input(T a) {
        this.t = a;
    }

    @Override
    public void output() {
        System.out.println(t);
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.say();
        System.out.println(demo.say(12323));
    }
}
