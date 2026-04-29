package remote;
import vendors.Television;

/**
 * A child class of action that increases the volume of a tv.
 * 
 * @author Willow Sapphire
 * @version Fall 2022
 */
public class Up extends Action
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
    public Up(Television tv)
    {
        super ("Volume Up");
        this.tv = tv;
    }

    public Up(SmartLight light)
    {
        super("Brightness Up");
        this.light = light;
    }

    public Up(Television tv, SmartLight light)
    {
        super("Volume/Brightness Up");
        this.tv = tv;
        this.light = light;
    }

    /**
     * Turns the volume of the tv up by one.
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
            else if (tv.getVolume() == tv.getMaxVolume())
            {
                System.out.println("Volume already at maximum");
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
            else if (light.getIntensity() == 100) {
                System.out.println("Brightness already at maximum");
                didntFail = false;
            }
            else {
                light.increaseIntensity();
                System.out.printf("Brightness up. Now at %d\%\n", light.getIntensity());
            }
        }
        
        return didntFail;
    }
}
