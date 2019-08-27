package prototype.demo1;

/**
 *
 * Prototype
 *
 */
public abstract class Prototype implements Cloneable {

    @Override
    public abstract Object clone() throws CloneNotSupportedException;

}
