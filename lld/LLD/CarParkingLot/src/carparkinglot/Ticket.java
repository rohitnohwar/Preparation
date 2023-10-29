package carparkinglot;

import carparkinglot.vehicle.Vehicle;
import java.util.List;

public class Ticket {
    private Vehicle vehicle;
    private ParkingFloor parkingFloor;

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    private List<ParkingSpot> parkingSpots;
    private int hours;

    public Ticket(Vehicle vehicle, ParkingFloor parkingFloor, List<ParkingSpot> parkingSpots, int hours) {
        this.vehicle = vehicle;
        this.parkingFloor = parkingFloor;
        this.parkingSpots = parkingSpots;
        this.hours = hours;
    }

    public int getCost() {
        int totalCost = 0;
        for (ParkingSpot parkingSpot: parkingSpots) {
            totalCost += hours * Charges.getCharges(vehicle.getVehicleType());
        }

        return totalCost;
    }
}
