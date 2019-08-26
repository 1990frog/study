package pattern.prototype.demo1;

/**
 *
 * OrcBeast
 *
 */
public class OrcBeast extends Beast {

    public OrcBeast() {}

    @Override
    public Beast clone() {
        return new OrcBeast();
    }

    @Override
    public String toString() {
        return "Orcish wolf";
    }

}
