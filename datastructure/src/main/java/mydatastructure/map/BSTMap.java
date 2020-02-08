package mydatastructure.map;

class Haha{
    public void test(){
        System.out.println("dododo");
    }
}

public class BSTMap {

    public static void main(String[] args) {
        Haha haha = new Haha(){
            public void test(){
                System.out.println("haha test !");
            }
        };
        haha.test();
    }
}

