import java.util.ArrayList;

/**
 * This is the machineElevator class describing the functionality of the elevator
 */
public class MachineRoomElevator extends Elevator
{

    ArrayList<ElevatorList> elevatorLists;


    /**
     *   Elevator : specifications defined : default starts with ground floor and direction as moving up
     */
    public MachineRoomElevator()
    {
        //boolean values set to default state of elevator
        this.setTotal_floor(4);
        this.setMaxCapacity(400);
        this.setMovingUp(true);
        this.setEnter(false);
        this.setExit(false);

        //object list
        elevatorLists=new ArrayList<>();
        this.floorButton=new FloorButton();
        this.elevatorButton=new ElevatorButton();
        this.param=new ButtonParam();
    }

    /**
     * This is to check which floor will the elevator move to
     */
    public void Floor()
    {

        if(this.elevatorLists.isEmpty())
        {
            System.out.println("Check whether there is anyone waiting for elevator at the any floor");
            int floor=this.floorButton.buttonON(param);
            if(this.floorButton.isIndicatorOn(param)==true){
                this.setCurrent_floor(floor);
                System.out.println("current Floor "+this.getCurrent_floor());
                return;
            }
            else
            {
                System.out.println("Elevator is in idle state ; No call for elevator at any floor ");

            }
        }
        else
        {
            this.param.setCurrentFloor(this.getCurrent_floor());
            int nextFloor=this.elevatorButton.buttonON(this.param);
            if(nextFloor!=this.getCurrent_floor() || nextFloor==this.getTotal_floor())
            {
                setCurrent_floor(nextFloor);
                System.out.println("Elevator ready to go at next floor : " + nextFloor);
            }
            else
            {
                System.out.println("Elevator stopped due to mechanic failure");
            }

        }

    }

    /**
     * This method starts the elevator
     * @param people This is queue of people waiting to board the eleavtor
     * @throws InterruptedException
     */
    public void startElevator(ArrayList<ElevatorPeople> people) throws InterruptedException
    {

        System.out.println("Elevator starts.........");
        System.out.println("Current floor " +this.getCurrent_floor());

        while(true)
        {
            synchronized (people) {

                //waits while the list is empty
                while (people.isEmpty()) {
                    people.wait();
                }

                //setting the value for button parameters
                this.param.setPeople(people);
                this.param.setTotalFloor(this.getTotal_floor());
                this.param.setElevatorLists(this.elevatorLists);

                this.Floor();
                if(!people.isEmpty())
                {
                    this.addToElevator(people);
                }

                if(this.isEnter()==true)
                {
                    this.removeFromElevator(people);
                }
                else
                {
                    System.out.println("No one has yet boarded the elevator ");
                }

                //Wake up producer thread
                people.notify();

                //and sleep
                Thread.sleep(4000);

            }
        }


    }

    /**
     * This is helper method to the totalWeight of the people present in the elevator
     * @return
     */

   public float totalWeight()
   {
       float totalWeight=0;

       for(int i=0;i<this.elevatorLists.size();i++)
       {
           totalWeight=totalWeight+this.elevatorLists.get(i).weight;
       }

       return totalWeight;
   }




    @Override
    /**
     * This method checks whether there are people waiting for the elevator .
     * if present adds them to the elevator list
     * @param people This represents the queue of people waiting to board the elevator at various floors
     */
    public void addToElevator(ArrayList<ElevatorPeople> people)
    {
        float totalWeight=0;
        int personId=1;

        for(int i=0;i<people.size();i++)
        {
            //people who are on the current floor will board the lift
            if(people.get(i).getSource()==this.getCurrent_floor())
            {
                int destination=people.get(i).destination;
                float weight =people.get(i).weight;
                totalWeight=this.totalWeight();
                if(totalWeight<this.getMaxCapacity())
                {

                    System.out.println("=========Elevator Opens door to board people===========");
                    System.out.println("People boarding the elevator at floor " +this.getCurrent_floor());
                    System.out.println("Person Id "+ personId);
                    System.out.println("destination "+ destination);
                    System.out.println("Weight of the person boarding the lift "+ weight);
                    ElevatorList elevatorList=new ElevatorList(destination,weight,this.current_floor);
                    System.out.println("Remove people from the queue which have boarded the lift ");
                    System.out.println("source : "+people.get(i).source + " Destination " + destination + " weight " +weight);
                    System.out.println("==================People boarded==========================");
                    this.setEnter(true);
                    people.remove(i);
                    elevatorLists.add(elevatorList);

                    //setting the elevator list
                    this.param.setElevatorLists(this.elevatorLists);
                }
                else
                {
                    this.setEnter(false);
                }
                personId++;

            }


        }

        if(this.isEnter()==true)
        {
            //System.out.println("People entered at the floor : " + this.current_floor);
        }
        else
        {
            System.out.println("No one  entered at the floor : " + this.current_floor);
        }



    }

    @Override
    /**
     * This method checks whether anyone wants to get down at particular floor
     * @param people This represents the queue of people waiting to board the elevator at various floors
     */
    public void removeFromElevator(ArrayList<ElevatorPeople> people)
    {
        int personId=1;

        for(int i=0;i<elevatorLists.size();i++)
        {
            //people who want to get down at the current floor
            if(elevatorLists.get(i).destination==this.getCurrent_floor())
            {

                System.out.println("##################Elevator Opens door to exit people############");
                System.out.println("People get down from the elevator ");
                System.out.println("Elevator at floor :" + this.getCurrent_floor());
                System.out.println("People Id :" + personId);
                System.out.println("Weight " + elevatorLists.get(i).weight);
                System.out.println("###########################People left###########################");
                this.setExit(true);
                elevatorLists.remove(i);
                personId++;
            }
            else
            {
                this.setExit(false);
            }

        }

        if(this.isExit()==true)
        {
          //  System.out.println("People exit at the floor : "+ this.current_floor );
        }
        else
        {
            System.out.println("No person exit the elevator at floor : "+ this.current_floor );
        }
    }

}

