package carparkinglot;

import carparkinglot.vehicle.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class AllowedSpots {
    private static final Map<VehicleType, Map<VehicleType, Boolean>> allowedSpots = new HashMap()
    {{
        put(VehicleType.MOTORCYCLE, new HashMap() {{
            put(VehicleType.MOTORCYCLE, true);
            put(VehicleType.COMPACT, true);
            put(VehicleType.LARGE, true);
        }} );

        put(VehicleType.COMPACT, new HashMap() {{
            put(VehicleType.COMPACT, true);
            put(VehicleType.LARGE, true);
        }} );

        put(VehicleType.LARGE, new HashMap() {{
            put(VehicleType.LARGE, true);
        }} );
    }};

    public static Map<VehicleType, Map<VehicleType, Boolean>> getAllowedSpots() {
        return allowedSpots;
    }
}
