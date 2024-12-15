package learn_loop;

public class InterruptWhile {

    public static void main(String[] args) {
        try {
            while (true){
                System.out.println("runtime exception");
                throw new RuntimeException("runtime exception");
            }
        }catch (Exception ignore){

        }finally {
            System.out.println("end");
        }
    }
}
