package carparkinglot.vehicle;

public class Bus extends Vehicle {
    public Bus(String name, String numberPlate) {
        this.name = name;
        this.numberPlate = numberPlate;
        this.vehicleType = VehicleType.LARGE;
        this.spotsNeeded = 5;
    }
}
