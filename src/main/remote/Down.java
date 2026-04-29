package remote;
import vendors.*;

/**
 * A child class of action that decreases the volume of a tv.
 * 
 * @author Willow Sapphire, Jesus Sisniega-Serrano
 * @version Spring 2026
 */
public class Down extends Action
{
    /**
     * The tv for which to change the volume.
     */
    private Television tv;

    private SmartLight light; 

    /**
     * Creates this action object.
     * 
     * @param tv the tv to connect to
     */
    public Down(Television tv)
    {
        super("Volume Down");
        this.tv = tv;
    }

    public Down(SmartLight light)
    {
        super("Brightness Down");
        this.light = light;
    }

    public Down(Television tv, SmartLight light)
    {
        super("Volume/Brightness Down");
        this.tv = tv;
        this.light = light;
    }

    /**
     * Turns the volume of the tv down by one.
     * 
     * @return false if the tv is not on yet or the volume is at zero, true otherwise
     */
    @Override
    public boolean performAction()
    {
        boolean didntFail = true;
        
        if (tv != null) {
            if (!tv.isOn())
            {
                System.out.println("You need to turn on the tv before you can change the volume.");
                didntFail = false;
            }
            else if (tv.getVolume() == 0)
            {
                System.out.println("Volume already at zero");
                didntFail = false;
            }
            else
            {
                tv.decreaseVolume();
                System.out.printf("Volume down. Now at %d\n", tv.getVolume());
            }
        }
        
        if (light != null) {
            if (!light.isOn()) {
                System.out.println("You need to turn on the light before you can change the brightness.");
                didntFail = false;
            else if (light.getIntensity() == 0) {
                System.out.println("Brightness already at zero");
                didntFail = false;
            }
            else {
                light.decreaseIntensity();
                System.out.printf("Brightness down. Now at %d\%\n", light.getIntensity());
            }
        }
        
        return didntFail;
    }
}
