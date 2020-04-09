package pattern.decorator.demo2;

public class SuperSaiyan2 extends SuperSaiyan1 {

    private String name;

    public SuperSaiyan2(){
        this.name = "超级赛亚人2";
        System.out.println(this.name);
    }

    public SuperSaiyan2(SuperSaiyan1 superSaiyan1){
        this();
        this.saiyan = superSaiyan1;
    }

    @Override
    public void call() {
        System.out.println("我是"+this.name);
    }

    @Override
    public void attack() {
        super.attack();
        System.out.println(this.name + "基础攻击力3000加成");
    }
}
