import java.util.ArrayList;

abstract class People extends Thread
{

    int source=0,destination=0;
    float weight=0;

    final int MAXPEOPLE=5;
    ArrayList<ElevatorPeople> people;

    public People(){};


    public People(int source, int destination, float weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    //abstract methods
    public abstract void addPeopleToQueue(int totalFloors,int maxCapacity)throws InterruptedException;

}
