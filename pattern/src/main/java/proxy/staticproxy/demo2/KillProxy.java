package proxy.staticproxy.demo2;

public class KillProxy {

    private Killer killer;

    public KillProxy(Killer killer){
        this.killer = killer;
    }

    public void kill(){
        System.out.println("选择killer");
        killer.kill();
    }
}
