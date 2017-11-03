import java.util.ArrayList;

/**
 * This is the ElevatorButton class describing the functionality of elevatorButton
 */

public class ElevatorButton extends Button
{
    //People want to get outside the lift
    ArrayList<ElevatorList> elevatorLists;
    int totalFloor=0,nextFloor;


    /**
     * This method checks whether the elevator is moving in upwards direction or downward
     */
    public void checkDirection()
    {
        if(this.nextFloor>this.totalFloor)
        {
            System.out.println("==Elevator resetting==");
            System.out.println("Elevator starts moving Down");
            this.nextFloor=this.nextFloor-2;
            this.setMovingDown(true);
            this.setMovingUP(false);
        }
        else if(nextFloor==0)
        {
            System.out.println("Elevator at the ground floor ");
            System.out.println("Elevator starts moving UP ");
            this.setMovingUP(true);
            this.setMovingDown(false);
        }
        else if(this.nextFloor==this.totalFloor)
        {
           this.nextFloor--;
           System.out.println("Elevator at the top floor ");
           System.out.println("Elevator starts moving Down");
           this.setMovingDown(true);
           this.setMovingUP(false);
        }
        else
        {
            System.out.println("Elevator direction has already been set ");
        }
    }


    @Override
    /**
     *
     * This method checks whether there are poeple in elevator .if poeple are present
     * than the nextFloor will be accordingly set
     * @param   param  This is object helps to determine the arrayList type based on the type of override class
     */
    public int buttonON(ButtonParam param) {

       this.elevatorLists=param.getElevatorLists();
       this.totalFloor=param.getTotalFloor();
       this.nextFloor=param.getCurrentFloor()+1;

       for(int i=0;i<this.elevatorLists.size();i++)
       {
           while(this.nextFloor!=this.elevatorLists.get(i).destination)
           {
               this.checkDirection();
               if (this.isMovingUP == true) {
                   if (this.elevatorLists.get(i).destination == this.nextFloor) {
                       System.out.println("Moving Upwards ");
                       System.out.println("Elevator will go to floor :" + nextFloor);
                       break;
                   } else {
                       this.nextFloor++;
                   }
               } else if (this.isMovingDown() == true) {


                   if (this.elevatorLists.get(i).destination == this.nextFloor) {
                       System.out.println("Moving Downwards ");
                       System.out.println("Elevator will go to floor :" + this.nextFloor);
                       break;
                   } else {
                       this.nextFloor--;
                   }
               }
           }
       }

        return  nextFloor;

    }

    @Override
    /**
     * Indicates the elevator button is on or off
     * @param  param  This is object helps to determine the arrayList type based on the type of override class
     */
    public boolean isIndicatorOn(ButtonParam param) {

        if(this.param.getElevatorLists().isEmpty())
        {
            this.setIndicatorOn(false);
            return false;
        }
        else
        {
            this.setIndicatorOn(true);
            return true;
        }

    }

    @Override
    /**
     * This method sets the value of the elevator button on if there are people in the elevator
     */
    public void setIndicatorOn(boolean elevatorIndicatorOn) {
        super.setIndicatorOn(elevatorIndicatorOn);
    }
}
