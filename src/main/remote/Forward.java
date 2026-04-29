package remote;
import vendors.*;

/**
 * A child class of action that changes the channel of a tv.
 * It moves the channel forward in the list of channels.
 * 
 * @author Willow Sapphire, Jesus Sisniega-Serrano
 * @version Spring 2026
 */
public class Forward extends Action
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
    public Forward(Television tv)
    {
        super("Next Channel");
        this.tv = tv;
    }

    public Forward(SmartLight light)
    {
        super("Next Color");
        this.light = light;
    }

    public Forward(Television tv, SmartLight light)
    {
        super("Next Channel/Color");
        this.tv = tv;
        this.light = light;
    }

    /**
     * Changes the channel of the provided tv forward by one.
     * 
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
                tv.goToChannel((tv.getCurrentStation() + 1) % tv.getNumChannels());
                System.out.printf("Next Channel. Now on station %d: %s\n",
                    tv.getCurrentStation(), tv.getCurrentChannel());
            }
        }

        if (light != null) {
            if (!light.isOn())
            {
                System.out.println("You need to turn on the light before you can change the color.");
                didntFail = false;
            }
            else
            {
                light.increaseColor();
                System.out.printf("Next Color. Now on color: %s\n", light.getColor().name());
            }
        }

        return didntFail;
    }
}
