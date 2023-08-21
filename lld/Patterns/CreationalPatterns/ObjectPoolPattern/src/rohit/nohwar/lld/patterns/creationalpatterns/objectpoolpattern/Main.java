package rohit.nohwar.lld.patterns.creationalpatterns.objectpoolpattern;

public class Main {
    public static void main(String args[]) {
        ObjectPool<VehicleInterface> op = new ObjectPool(new Car(), 5);

        VehicleInterface car1 = op.get();
        car1.setDrive("Honda");
        car1.setPark("Gallery");

        car1.drive();
        car1.park();

        op.release(car1);
    }
}
