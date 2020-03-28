package base.keyword.$default;

public interface MyInterface<T> {

    void input(T a);
    void output();

    default void say(){
        System.out.println("foobar!");
    }

    default <K> K say(K k){
        return k;
    }

    static void play(){
        System.out.println("this is a interface static method!");
    }
}
