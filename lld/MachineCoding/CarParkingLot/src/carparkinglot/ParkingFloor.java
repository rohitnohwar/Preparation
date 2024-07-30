package carparkinglot;

import carparkinglot.ParkingSpot;
import carparkinglot.vehicle.Vehicle;
import carparkinglot.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingFloor {
    private int floorNumber;
    private Map<VehicleType, Map<Integer, ParkingSpot>> spots;

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Map<VehicleType, Map<Integer, ParkingSpot>> getSpots() {
        return spots;
    }

    public void setSpots(Map<VehicleType, Map<Integer, ParkingSpot>> spots) {
        this.spots = spots;
    }

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        Map<VehicleType, Map<Integer, ParkingSpot>> spots = new HashMap<>();
    }

    public List<ParkingSpot> findFreeSpots(Vehicle vehicle) {
        Map<VehicleType, Map<VehicleType, Boolean>> allowedSpots = AllowedSpots.getAllowedSpots();

        for (Map.Entry<VehicleType, Boolean> spotsType: allowedSpots.get(vehicle.getVehicleType()).entrySet()) {
            for(Map.Entry<Integer, ParkingSpot> spot: spots.get(spotsType.getKey()).entrySet()) {
                int currSpot = spot.getKey();
                while (true) {
                    if (spots.get(spotsType).containsKey(currSpot - 1) && spots.get(spotsType).get(currSpot - 1).getVehicle() == null) {
                        currSpot -= 1;
                    }
                    else {
                        break;
                    }
                }

                int neededSpots = vehicle.getSpotsNeeded();
                List<ParkingSpot> potentialSpots = new ArrayList<>();

                while (neededSpots != 0) {
                    if (spots.get(spotsType).get(currSpot).getVehicle() == null) {
                        potentialSpots.add(spots.get(spotsType).get(currSpot));
                        neededSpots -= 1;
                    }
                    else break;
                }

                if (potentialSpots.size() == vehicle.getSpotsNeeded()) return potentialSpots;
            }
        }

        return new ArrayList<ParkingSpot>();
    }
}
