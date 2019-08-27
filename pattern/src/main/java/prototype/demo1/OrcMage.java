package prototype.demo1;

/**
 *
 * OrcMage
 *
 */
public class OrcMage extends Mage {

    public OrcMage() {}

    @Override
    public Mage clone() {
        return new OrcMage();
    }

    @Override
    public String toString() {
        return "Orcish mage";
    }

}
