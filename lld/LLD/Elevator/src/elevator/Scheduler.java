package elevator;

import java.util.*;

public class Scheduler {
    Map<Elevator, Map<Request, Request>> upElevators;
    Map<Elevator, Map<Request, Request>> downElevators;
    Map<String, Elevator> elevators;
    Map<Integer, Floor> floors;

    public Scheduler() {
        upElevators = new HashMap<>();
        downElevators = new HashMap<>();
        elevators = new HashMap<>();
        floors = new HashMap<>();
    }

    public void setRequest(Request request) {
        Elevator bestElevator = null;
        int leastDiff = Integer.MAX_VALUE;
        boolean upElevator = false;
        if (request.sourceFloor == request.destinationFloor) return;
        Map<Elevator, Map<Request, Request>> map = null;
        if (request.sourceFloor.number - request.destinationFloor.number > 0) {
            map = downElevators;
        }
        else if (request.sourceFloor.number - request.destinationFloor.number < 0) {
            map = upElevators;
            upElevator = true;
        }

        for (Map.Entry<Elevator, Map<Request, Request>> m: map.entrySet()) {
            for (Map.Entry<Request, Request> r: m.getValue().entrySet()) {
                Request req = r.getValue();
                if (req.sourceFloor == request.sourceFloor && req.destinationFloor == request.destinationFloor) {
                    return;
                }

                if (req.sourceFloor.number - request.sourceFloor.number < leastDiff) {
                    leastDiff = req.sourceFloor.number - request.sourceFloor.number;
                    bestElevator = m.getKey();
                }
            }
        }

        if (bestElevator != null) {
            Map<Request, Request> best = map.get(bestElevator);
            best.put(request, request);
        }
        else {
            map.put(elevators.get("1"), new HashMap<>());
            Map<Request, Request> currRequestSet = map.get(elevators.get("1"));
            currRequestSet.put(request, request);
//            best.add(request);
        }
    }

    public Floor addFloor(int number) {
        Floor floor = new Floor(number);
        floors.put(number, floor);
        return floor;
    }

    public Elevator addElevator(String name, Floor floor) {
        Elevator elevator = new Elevator(name, floor);
        elevators.put(name, elevator);
        return elevator;
    }
}
