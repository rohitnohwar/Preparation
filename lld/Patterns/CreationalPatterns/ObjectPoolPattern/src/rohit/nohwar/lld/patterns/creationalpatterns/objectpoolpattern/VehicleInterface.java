package rohit.nohwar.lld.patterns.creationalpatterns.objectpoolpattern;

public interface VehicleInterface extends Poolable{
    void drive();
    void park();

    void setDrive(String car);

    void setPark(String park);
}
