package pattern.prototype.demo1;

/**
 *
 * Beast
 *
 */
public abstract class Beast extends Prototype {

    @Override
    public abstract Beast clone() throws CloneNotSupportedException;

}
