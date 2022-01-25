package decorator.demo3;

public class GeneralMilletCongee implements MilletCongee{

    @Override
    public void printIngredient() {
        System.out.println("不加糖的小米粥，组成成分是小米和水");
    }

}
