package pattern.flyweight.demo3;

/**
 *
 * HealingPotion
 *
 */
public class HealingPotion implements Potion {

    @Override
    public void drink() {
        System.out.println("You feel healed. (Potion=" + System.identityHashCode(this) + ")");
    }
}
