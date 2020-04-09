package pattern.chain;

import java.util.Random;

public class App {

    public static void main(String[] args){

        Customer customer = new Customer();
        customer.setPriceHandler(PriceHandlerFactory.createPriceHandler());

        Random rand = new Random();

        for(int i=1;i<=100;i++){
            System.out.print(i+":");
            customer.requestDiscount(rand.nextFloat());
        }
    }

}
