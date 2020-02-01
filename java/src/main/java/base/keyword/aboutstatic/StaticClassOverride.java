package base.keyword.aboutstatic;

class SuperClass{
    static void play(){
        System.out.println("SuperClass play");
    }

    void notPlay(){
        System.out.println("SuperClass Not Play");
    }
}

public class StaticClassOverride extends SuperClass {

    static void play(){
        System.out.println("StaticClassOverride play");
    }

    @Override
    void notPlay(){
        System.out.println("StaticClassOverride not play");
        super.notPlay();
    }


    public static void main(String[] args) {
        StaticClassOverride.play();
        StaticClassOverride so = new StaticClassOverride();
        so.notPlay();
    }

}
