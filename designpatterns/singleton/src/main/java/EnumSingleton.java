import java.util.concurrent.atomic.AtomicLong;

public enum EnumSingleton {
    INSTANCE;
    private final AtomicLong id = new AtomicLong();

    public long getId() {
        return id.incrementAndGet();
    }
}
