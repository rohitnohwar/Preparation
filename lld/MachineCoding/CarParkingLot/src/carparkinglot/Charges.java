package carparkinglot;

import carparkinglot.vehicle.VehicleType;

public class Charges {
    public static int getCharges(VehicleType vehicleType) {
        switch (vehicleType) {
            case MOTORCYCLE: return 1;
            case COMPACT: return 2;
            case LARGE: return 3;
            default: return 0;
        }
    }
}
