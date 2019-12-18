package builder.demo4;

public abstract class Builder {
    abstract void buildFrame();
    abstract void buildSeat();
    abstract void buildTire();
    abstract Bike createBike();
}
