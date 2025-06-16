package learn_immutability.delegating;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class Point {

    public final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class DelegatingVehicleTracker {
    private final ConcurrentHashMap<String, Point> locations;

    public DelegatingVehicleTracker(Map<String, Point> points) {
        locations = new ConcurrentHashMap<String, Point>(points);
    }

    public Map<String, Point> getLocations() {
        return Collections.unmodifiableMap(locations);
    }

    public Point getLocation(String id) {
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y) {
        if (locations.replace(id, new Point(x, y)) == null) {
            throw new IllegalArgumentException("invalid vehicle name: " + id);
        }
    }
}
