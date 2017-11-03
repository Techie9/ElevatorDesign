import java.util.ArrayList;
import java.util.Random;

/**
 * This is class resembles the producer thread
 */
public class ElevatorPeople extends People
{


    public ElevatorPeople(){System.out.println("Adding People to queue to enter the Elevator ");};

    public ElevatorPeople(int source, int destination, float weight)
    {
        super(source, destination, weight);
    }

    @Override
    /**
     * This metdhod adds the people to the queue
     * @param totalFloors  This is the totalfloor of the elevator
     * @param maxCapacity  This is the maxCapacity of the elevator
     */
    public void addPeopleToQueue(int totalFloors,int maxCapacity) throws InterruptedException
    {
        this.people=new ArrayList<>();

        System.out.println("Total number of floors :"+totalFloors);

        int personId=1;

        while (true)
        {
            synchronized (people) {
                //producer thread waits while the list is full
                while (people.size() == this.MAXPEOPLE) {
                    people.wait();
                }
            }


            synchronized (people)
            {
                //person : weight,source ,destination
                this.source = 0 + (int) ((Math.random() * totalFloors) + 1);

                this.destination = 0 + (int) ((Math.random() * totalFloors) + 1);

                //if source and destination is same change the value of destination
                while (this.source == this.destination) {
                    this.destination = 0 + (int) ((Math.random() * totalFloors) + 0);
                }
                weight = new Random().nextFloat() * 101 + 40; //upperbound =101 lowerbound=40

                System.out.println("Person adding to the queue : " + personId);
                System.out.println("Source :" + this.source);
                System.out.println("Destination :" + this.destination);
                System.out.println("Weight :" + this.weight);

                //creating person
                ElevatorPeople elevatorPeople = new ElevatorPeople(source, destination, weight);

                //adding this person to queue
                this.people.add(elevatorPeople);

                personId++;

                //wake up the consumer thread
                people.notify();

                //and sleep
                Thread.sleep(1000);

            }

        }

    }



}
