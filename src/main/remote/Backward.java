package remote;
import vendors.*;

/**
 * A child class of action that changes the channel of a tv.
 * It move the channel backward in the list of channels.
 * 
 * @author Willow Sapphire, Jesus Sisniega-Serrano
 * @version Spring 2026
 */
public class Backward extends Action
{
    /**
     * The tv for which to change the channel.
     */
    private Television tv;

    private SmartLight light; 
    
    /**
     * Creates this action object.
     * 
     * @param tv the tv to connect to
     */
    public Backward(Television tv)
    {
        super("Previous Channel");
        this.tv = tv;
    }

    public Backward(SmartLight light)
    {
        super("Previous Color");
        this.light = light;
    }

    public Backward(Television tv, SmartLight light)
    {
        super("Previous Channel/Color");
        this.tv = tv;
        this.light = light;
    }

    /**
     * Changes the channel of the provided tv backward by one.
     * @return false if the tv is not on yet, true otherwise
     */
    @Override
    public boolean performAction()
    {
        boolean didntFail = true;
        if (tv != null) {
            if (!tv.isOn())
            {
                System.out.println("You need to turn on the tv before you can change the channel.");
                didntFail = false;
            }
            else
            {
                tv.goToChannel((tv.getCurrentStation() - 1 + tv.getNumChannels()) % tv.getNumChannels());
                System.out.printf("Previous Channel. Now on station %d: %s\n",
                    tv.getCurrentStation(), tv.getCurrentChannel());
            }
        }

        if (light != null) {
            if (!tv.isOn())
            {
                System.out.println("You need to turn on the light before you can change the color.");
                didntFail = false;
            }
            else
            {
                light.decreaseColor();
                System.out.printf("Previous Color. Now on color: %s\n", light.getColor());
            }
        }

        return didntFail;
    }


}
