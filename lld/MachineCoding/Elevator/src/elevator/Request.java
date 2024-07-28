package elevator;

public class Request {
    Floor sourceFloor;
    Floor destinationFloor;

    public Request(Floor sourceFloor, Floor destinationFloor) {
        this.sourceFloor = sourceFloor;
        this.destinationFloor = destinationFloor;
    }
}
