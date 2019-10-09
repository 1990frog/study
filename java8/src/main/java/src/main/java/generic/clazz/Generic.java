package src.main.java.generic.clazz;

/**
 * 这是一个标准泛型类
 *
 * @param <T>
 */
public class Generic<T> {

    public T name;

    public Generic(T param) {
        name = param;
    }

    public T m() {
        return name;
    }

}
