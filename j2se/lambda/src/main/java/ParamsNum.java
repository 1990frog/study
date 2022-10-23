import java.util.function.BiFunction;
import java.util.function.Function;

class Math{
    private Integer x;
    private Integer y;
    private Integer z;
    public Math(Integer x,Integer y,Integer z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return String.valueOf(x+y+z);
    }
}

public class ParamsNum {

    @FunctionalInterface
    interface TriFunction<T,U,V,R>{
        R apply(T t,U u,V v);
    }

    public static void main(String[] args) {
        Function<Integer,String> func1 = String::valueOf;
        BiFunction<String,String,Boolean> func2 = String::contains;
        TriFunction<String,String,String,String> func3 = (t,u,v)->t+u+v;
        TriFunction<Integer,Integer,Integer,Math> func4 = Math::new;

        System.out.println(func1.apply(12));
        System.out.println(func2.apply("help", "h"));
        System.out.println(func3.apply("a", "o", "c"));
        System.out.println(func4.apply(1, 2, 3));
    }

}
