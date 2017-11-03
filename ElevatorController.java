/**
 * @author pallavi
 * This is the main class which creates the thread for prodcuer as well as consumer
 */

public class ElevatorController
{

    People people;
    Elevator elevator;


    ElevatorController()
    {
        people=new ElevatorPeople();
        elevator=new MachineRoomElevator();

    }


    public static void main(String[] args) throws InterruptedException
    {

        ElevatorController es =new ElevatorController();
        int totalFloors=es.elevator.total_floor;
        int maxCapacity=es.elevator.maxCapacity;

        //create producer thread
        Thread t1 =new Thread(new Runnable(){
            @Override
            public void run()
            {
                try
                {
                    es.people.addPeopleToQueue(totalFloors,maxCapacity);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

            }
        });



        //create consumer thread
        Thread t2 =new Thread(new Runnable(){
            @Override
            public void run()
            {
                try
                {
                    es.elevator.startElevator(es.people.people);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

            }
        });

        t1.start();
        t2.start();

        //t1 finishes before t2
        t1.join();
        t2.join();


    }

}
