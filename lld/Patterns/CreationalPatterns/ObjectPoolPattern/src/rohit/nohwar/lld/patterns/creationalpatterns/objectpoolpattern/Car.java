package rohit.nohwar.lld.patterns.creationalpatterns.objectpoolpattern;

public class Car implements VehicleInterface{
    private String drive = "";
    private String park = "";

    public void setDrive(String drive) {
        this.drive = drive;
    }

    public void setPark(String park) {
        this.park = park;
    }

    public void drive() {
        System.out.println("Driving " + drive);
    }

    public void park() {
        System.out.println("Parking in" + park);
    }

    public void reset() {
        drive = "";
        park = "";
    }
}
