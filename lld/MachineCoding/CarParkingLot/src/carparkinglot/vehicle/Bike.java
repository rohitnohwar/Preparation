package carparkinglot.vehicle;

public class Bike extends Vehicle{
    public Bike(String name, String numberPlate) {
        this.name = name;
        this.numberPlate = numberPlate;
        this.vehicleType = VehicleType.MOTORCYCLE;
        this.spotsNeeded = 1;
    }
}
