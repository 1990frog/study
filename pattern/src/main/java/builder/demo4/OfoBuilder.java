package builder.demo4;

public class OfoBuilder extends Builder {
    private Bike mBike = new Bike();
    @Override
    void buildFrame() {
        mBike.setFrame(Frame.builder().build());
    }
    @Override
    void buildSeat() {
        mBike.setSeat(Seat.builder().build());
    }
    @Override
    void buildTire() {
        mBike.setTire(Tire.builder().build());
    }
    @Override
    Bike createBike() {
        return mBike;
    }
}
