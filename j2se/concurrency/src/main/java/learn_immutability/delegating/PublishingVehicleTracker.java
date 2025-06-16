package learn_immutability.delegating;

import java.util.Collections;
import java.util.Map;

class SafePoint {
    private int x, y;

    private SafePoint(int[] a) {
        this(a[0], a[1]);
    }

    private SafePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private SafePoint(SafePoint p) {
        this(p.get());
    }

    public synchronized int[] get() {
        return new int[]{x, y};
    }

    public synchronized void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class PublishingVehicleTracker {
    private final Map<String, SafePoint> locations;
    private final Map<String, SafePoint> unmodifiableMap;

    public PublishingVehicleTracker(Map<String, SafePoint> locations) {
        this.locations = locations;
        this.unmodifiableMap = Collections.unmodifiableMap(locations);
    }

    public Map<String, SafePoint> getLocations() {
        return unmodifiableMap;
    }

    public SafePoint getLocation(String id) {
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y) {
        if (!locations.containsKey(id)) {
            throw new IllegalArgumentException("Location " + id + " does not exist");
        }
        locations.get(id).set(x, y);
    }
}
