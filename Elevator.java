import java.util.ArrayList;

abstract class Elevator extends Thread  {

    int current_floor;
    int total_floor,maxCapacity;
    boolean movingUp,isEnter,isExit;
    Button floorButton,elevatorButton;
    ButtonParam param;




    //abstract methods
    public abstract void startElevator(ArrayList<ElevatorPeople> people) throws InterruptedException;
    public abstract void addToElevator(ArrayList<ElevatorPeople> people);
    public abstract void removeFromElevator(ArrayList<ElevatorPeople> people);



    public int getCurrent_floor() {
        return current_floor;
    }

    public void setCurrent_floor(int current_floor) {
        this.current_floor = current_floor;
    }

    public int getTotal_floor() {
        return total_floor;
    }

    public void setTotal_floor(int total_floor) {
        this.total_floor = total_floor;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public boolean isMovingUp() {
        return movingUp;
    }

    public void setMovingUp(boolean movingUp) {
        this.movingUp = movingUp;
    }

    public boolean isEnter() {
        return isEnter;
    }

    public void setEnter(boolean enter) {
        isEnter = enter;
    }

    public boolean isExit() {
        return isExit;
    }

    public void setExit(boolean exit) {
        isExit = exit;
    }

    public Button getButton() {
        return floorButton;
    }

    public void setButton(Button floorButton) {
        this.floorButton = floorButton;
    }

    public Button getFloorButton() {
        return floorButton;
    }

    public void setFloorButton(Button floorButton) {
        this.floorButton = floorButton;
    }

    public Button getElevatorButton() {
        return elevatorButton;
    }

    public void setElevatorButton(Button elevatorButton) {
        this.elevatorButton = elevatorButton;
    }

    public ButtonParam getParam() {
        return param;
    }

    public void setParam(ButtonParam param) {
        this.param = param;
    }
}
