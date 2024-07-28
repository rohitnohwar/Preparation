package elevator;

public class Elevator {
    private String name;
    private Floor currentFloor;
    State state;

    public Elevator(String name, Floor currentFloor) {
        this.name = name;
        this.currentFloor = currentFloor;
        state = State.notMoving;
    }

    public void setCurrentFloor(Floor currentFloor) {
        this.currentFloor = currentFloor;
    }
}

enum State {
    movingUp,
    movingDown,
    notMoving
}
