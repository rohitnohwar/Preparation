package carparkinglot.vehicle;

public class Car extends Vehicle {
    public Car(String name, String numberPlate) {
        this.name = name;
        this.numberPlate = numberPlate;
        this.vehicleType = VehicleType.COMPACT;
        this.spotsNeeded = 1;
    }
}
