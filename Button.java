import java.util.ArrayList;

abstract public class Button
{
    boolean IndicatorON=false;
    boolean isMovingDown=false,isMovingUP=true;
    ButtonParam param;



    abstract boolean isIndicatorOn(ButtonParam  param);

    public void setIndicatorOn(boolean IndicatorOn) {
        IndicatorON = IndicatorOn;
    }

    public boolean isMovingDown() {
        return isMovingDown;
    }

    public void setMovingDown(boolean movingDown) {
        isMovingDown = movingDown;
    }

    abstract public int buttonON(ButtonParam param);

    public boolean isMovingUP() {
        return isMovingUP;
    }

    public void setMovingUP(boolean movingUP) {
        isMovingUP = movingUP;
    }
}

