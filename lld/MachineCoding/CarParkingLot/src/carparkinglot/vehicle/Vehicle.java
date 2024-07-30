package carparkinglot.vehicle;

public abstract class Vehicle {
    protected String name;
    protected String numberPlate;
    protected VehicleType vehicleType;
    protected int spotsNeeded;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public void setSpotsNeeded(int spotsNeeded) {
        this.spotsNeeded = spotsNeeded;
    }
}
