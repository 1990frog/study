package pattern.decorator.demo3;

public class Order {


    public static void main(String[] args) {
        MilletCongee milletCongee=new GeneralMilletCongee();
//        milletCongee.printIngredient();

        milletCongee=new SugarDecorator(milletCongee);
        milletCongee.printIngredient();
    }

}
