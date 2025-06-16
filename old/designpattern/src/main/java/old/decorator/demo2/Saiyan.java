package old.decorator.demo2;

public abstract class Saiyan {

    protected Saiyan saiyan;
    protected String name;
    protected int level;

    public Saiyan(){
        this.level = 0;
    }

    public Saiyan(Saiyan saiyan){
        this.saiyan = saiyan;
    }

    public abstract void call();

    public abstract void attack();

}
