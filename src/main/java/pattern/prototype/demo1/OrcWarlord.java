package pattern.prototype.demo1;

/**
 *
 * OrcWarlord
 *
 */
public class OrcWarlord extends Warlord {

    public OrcWarlord() {}

    @Override
    public Warlord clone() {
        return new OrcWarlord();
    }

    @Override
    public String toString() {
        return "Orcish warlord";
    }

}
