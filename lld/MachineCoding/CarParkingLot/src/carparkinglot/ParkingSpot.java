package carparkinglot;

import carparkinglot.vehicle.Vehicle;
import carparkinglot.vehicle.VehicleType;

public class ParkingSpot {
    private int number;
    private VehicleType vehicleType;

    private Vehicle vehicle;

    public ParkingSpot(int number, VehicleType vehicleType) {
        this.number = number;
        this.vehicleType = vehicleType;
        this.vehicle = null;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
