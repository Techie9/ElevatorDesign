public class ElevatorList
{
    int destination;
    int floor;
    float weight;

    ElevatorList(int destination,float weight,int floor)
    {
        this.destination=destination;
        this.weight=weight;
        this.floor=floor;
    }

    public int getDestination()
    {
        return destination;
    }

    public void setDestination(int destination)
    {
        this.destination = destination;
    }

    public float getWeight()
    {
        return weight;
    }

    public void setWeight(float weight)
    {
        this.weight = weight;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
