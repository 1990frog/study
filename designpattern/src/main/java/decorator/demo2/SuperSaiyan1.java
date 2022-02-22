package decorator.demo2;

public class SuperSaiyan1 extends Saiyan {

    protected Saiyan saiyan;
    private String name;

    public SuperSaiyan1(){
        this.name = "超级赛亚人1";
        System.out.println(this.name);
    }

    public SuperSaiyan1(Saiyan saiyan){
        this.saiyan = saiyan;
    }

    @Override
    public void call() {
        System.out.println("我是"+this.name);
    }

    @Override
    public void attack() {
        System.out.println(this.name + "基础攻击力1000加成");
    }
}
