package decorator.demo3;

/**
 * 糖装饰器，用来给小米粥加糖
 */
public class SugarDecorator implements MilletCongee {

    /**
     * 拥有的小米粥对象
     */
    private final MilletCongee milletCongee;

    public SugarDecorator(MilletCongee milletCongee) {
        this.milletCongee = milletCongee;
    }

    @Override
    public void printIngredient() {
        System.out.println("糖");
        this.milletCongee.printIngredient();
    }
}