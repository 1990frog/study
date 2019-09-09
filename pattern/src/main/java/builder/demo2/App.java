package builder.demo2;

public class App {
    public static void main(String[] args) {
        showBike(new OfoBuilder());
        showBike(new MobikeBuilder());
    }
    private void showBike(Builder builder) {
        Director director = new Director(builder);
        Bike bike = director.construct();
        bike.getFrame().frame();
        bike.getSeat().seat();
        bike.getTire().tire();
    }
}
