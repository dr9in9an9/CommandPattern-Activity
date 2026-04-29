package remote;
import vendors.*;

/**
* A child class of action that turns a tv on or off.
*  
*
* @author Willow Sapphire, Jesus Sisniega-Serrno
* @version Spring 2026
*/
public class Power extends Action
{
    /**
     * The tv to turn on.
     */
    private Television tv;
	
	private SmartLight light;

    /**
     * Creates this action object.
     * 
     * @param tv the tv to connect to
     */
    public Power(Television tv)
    {
        super("TV Power");
        this.tv = tv;
    }

	public Power(SmartLight light) {
		super("Light Power");
		this.light = light;
	}

	public Power(Television tv, SmartLight light) {
		super("TV/Light Power");
		this.tv = tv;
		this.light = light;
	}

    /**
     * Find which object the power button is connect to. 
     * Then turns that object on if it is off or off if it is on.
     * 
     * @return true. this action cannot fail.
     */
    @Override
    public boolean performAction()
    {
        if (tv != null || light != null) {
			if (tv != null) {
				tv.power();
        		System.out.printf("The tv has turned %s\n", tv.isOn() ? "on" : "off");
        		if (tv.isOn())
        		{
            			System.out.printf("Volume: %d\nChannel: %s\n", tv.getVolume(), tv.getCurrentChannel());
        		}
			}
			if (light != null) {
				light.power();
				System.out.printf("The smart light is %s\n", light.isOn() ? "on" : "off");
				if (tv.isOn())
        		{
            			System.out.printf("Brightness: %d\%\nColor: %s\n", light.getIntensity(), light.getCurrColor().name());
        		}
			}

			return true;
		}
		else {
			return false;
		}
    }
}
