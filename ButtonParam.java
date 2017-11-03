import java.util.ArrayList;

public class ButtonParam
{
   private  ArrayList<ElevatorList> elevatorLists;
   private  ArrayList<ElevatorPeople> people;
   private int currentFloor,totalFloor;

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public ArrayList<ElevatorList> getElevatorLists() {
        return elevatorLists;
    }

    public void setElevatorLists(ArrayList<ElevatorList> elevatorLists) {
        this.elevatorLists = elevatorLists;
    }

    public ArrayList<ElevatorPeople> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<ElevatorPeople> people) {
        this.people = people;
    }

    public int getTotalFloor() {
        return totalFloor;
    }

    public void setTotalFloor(int totalFloor) {
        this.totalFloor = totalFloor;
    }
}
