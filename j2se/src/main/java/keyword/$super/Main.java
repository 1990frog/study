package keyword.$super;

class Father{
    public void foo(){
        System.out.println("father");
    }
}

public class Main extends Father{

    private void printSuper(){
        System.out.println(super.hashCode());
    }

    private void printThis(){
        System.out.println(this.hashCode());
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.printSuper();
        main.printThis();
    }
}
/**
 * out:
 * 1650967483
 * 1650967483
 */
