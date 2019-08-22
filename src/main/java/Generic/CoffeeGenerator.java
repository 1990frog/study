package Generic;

import java.util.Iterator;
import java.util.Random;

class Coffee {
    private long counter = 0;
    private final long id = counter++;
    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}

class Latte extends Coffee {}
class Mocha extends Coffee {}
class Cappuccino extends Coffee {}
class Americano extends Coffee {}
class Breve extends Coffee {}

/**
 * 参数化的Generatoer的接口确保next()的返回值是参数的类型。
 * CoffeeGenerator同时还实现了Iterable接口,所以它可以在ForEach循环中被使用。
 * 不过，它还需要一个“末端哨兵”来判断何时停止，这正是第二个构造器的功能。
 */
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {

    private Class[] types = {Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class};

    private Random rand = new Random(47);

    public CoffeeGenerator() {
    }

    private int size = 0;

    public CoffeeGenerator(int size) {
        this.size = size;
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee) types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class CoffeeIterator implements Iterator<Coffee> {

        int count = size;

        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println("gen.next() = " + gen.next());
        }
        for (Coffee coffee : new CoffeeGenerator(5)) {
            System.out.println("coffee = " + coffee);
        }
    }

}
