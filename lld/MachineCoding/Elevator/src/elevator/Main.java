package elevator;

public class Main {
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();

        Floor floor1 = scheduler.addFloor(1);
        Floor floor2 = scheduler.addFloor(2);
        Floor floor3 = scheduler.addFloor(3);
        Floor floor4 = scheduler.addFloor(4);
        Floor floor5 = scheduler.addFloor(5);
        Floor floor6 = scheduler.addFloor(6);
        Floor floor7 = scheduler.addFloor(7);
        Floor floor8 = scheduler.addFloor(8);
        Floor floor9 = scheduler.addFloor(9);
        Floor floor10 = scheduler.addFloor(10);

        Elevator elevator1 = scheduler.addElevator(String.valueOf(1), floor1);
        Elevator elevator2 = scheduler.addElevator(String.valueOf(2), floor2);
        Elevator elevator3 = scheduler.addElevator(String.valueOf(3), floor3);

        Request request1 = new Request(floor8, floor2);
        scheduler.setRequest(request1);
        Request request2 = new Request(floor7, floor1);
        scheduler.setRequest(request2);
    }
}
