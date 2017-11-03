import java.util.ArrayList;

/**
 * This class describes the floorButton properties
 */
public class FloorButton extends Button
{
    //To indicate people want to get inside the lift


    @Override
    /**
     * This method checks whether the people are waiting for elevator
     * @param people This represents the queue of people waiting to board the elevator at various floors
     */
    public int buttonON(ButtonParam param)
    {
        int floor=-1;
        ArrayList<ElevatorPeople> people;

        //if people queue is not empty means people are waiting in the queue to board lift
        if(!param.getPeople().isEmpty())
        {
            people=param.getPeople();
            floor=people.get(0).source;
            System.out.println("People are waiting at this floor for elevator " + floor);
            setIndicatorOn(true);
        }
        else
        {
            setIndicatorOn(false);
        }

        return floor;

    }

    @Override
    /**
     * This methods check whether the
     * @param param
     */
    public boolean isIndicatorOn(ButtonParam param)
    {
        if(!param.getPeople().isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public void setIndicatorOn(boolean IndicatorON) {
        super.setIndicatorOn(IndicatorON);
    }
}
