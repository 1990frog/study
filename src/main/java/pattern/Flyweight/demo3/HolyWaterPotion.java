package pattern.Flyweight.demo3;

/**
 *
 * HolyWaterPotion
 *
 */
public class HolyWaterPotion implements Potion {

    @Override
    public void drink() {
        System.out.println("You feel blessed. (Potion=" + System.identityHashCode(this) + ")");
    }
}
