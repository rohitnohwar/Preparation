package carparkinglot;

import carparkinglot.vehicle.Vehicle;
import carparkinglot.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private final String name;

    private Map<Integer, ParkingFloor> parkingFloors;

    private Map<VehicleType, Integer> freeSpots;
    private List<Ticket> tickets = new ArrayList<>();

    public ParkingLot(String name) {
        this.name = name;
    }

    public void addFloors(int floor) {
        this.parkingFloors.put(floor, new ParkingFloor(floor));
    }

    public void addSpots(int spot, int floor, VehicleType vehicleType) {
        Map<Integer, ParkingSpot> m = parkingFloors.get(floor).getSpots().getOrDefault(vehicleType, new HashMap<>());
        m.put(spot, new ParkingSpot(spot, vehicleType));
        freeSpots.put(vehicleType, freeSpots.getOrDefault(vehicleType, 0) + 1);
    }

    public Ticket Park(Vehicle vehicle, int hours) {
        List<ParkingSpot> spots = new ArrayList<>();
        int parkingFloor = Integer.MAX_VALUE;
        for(Map.Entry<Integer, ParkingFloor> floor: parkingFloors.entrySet()) {
            spots = floor.getValue().findFreeSpots(vehicle);
            if (spots.size() != 0) {
                parkingFloor = floor.getKey();
                break;
            }
        }

        if (freeSpots.size() != 0) {
            freeSpots.put(spots.get(0).getVehicleType(), freeSpots.get(spots.get(0).getVehicleType()) - spots.size());
            Ticket ticket = new Ticket(vehicle, parkingFloors.get(parkingFloor), spots, hours);
            return ticket;
        }
        else {
            return null;
        }
    }

    public int removeParkedVehicle(Ticket ticket) {
        List<ParkingSpot> spots = ticket.getParkingSpots();

        VehicleType spotsType = spots.get(0).getVehicleType();

        freeSpots.put(spotsType, freeSpots.getOrDefault(spotsType, 0) + spots.size());

        int totalCharge = ticket.getCost();

        for (ParkingSpot parkingSpot: spots) {
            parkingSpot.setVehicle(null);
        }

        return totalCharge;
    }
}
