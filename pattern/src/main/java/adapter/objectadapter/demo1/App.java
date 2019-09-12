package adapter.objectadapter.demo1;

public class App {

    public static void main(String[] args) {
        VoltageAdapter voltageAdapter = new VoltageAdapter(new Voltage220());
        Mobile mobile = new Mobile();
        mobile.charging(voltageAdapter);
    }
}
