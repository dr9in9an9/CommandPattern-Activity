package vendors;

public class SmartLight {
	/*Shorthand names for main colors.
	*/
	private enum Colors { WHT, RED, ORN, YLW, GRN, BLU, PUR }
		
	private final Colors[] colors;

	private boolean isOn;
	
	/*This represents percentage of light-hardware's maximum. 100% is its max.
	*/
	private int intensityOfLight;

	private Colors currColor; 

	public SmartLight() {
		this.colors = Colors.values();
		this.isOn = false;
		this.intensityOfLight = 50;
		this.currColor = Colors.WHT;
	}

	public void power() {
		isOn = !isOn; 
	}
	
	public void increaseIntensity() {
		intensityOfLight += 5;
	}

	public void decreaseIntensity() {
                intensityOfLight -= 5;
        }
	
	public void increaseColor() {
		currColorIndex = currColor.ordinal();
		if (currColorIndex + 1 < colors.length) {
			currColor = colors[currColorsIndex + 1];
		}
		else {
			currColor = colors[0];
		}
        }
	
	public void decreaseColor() {
                currColorIndex = currColor.ordinal();
                if (currColorIndex - 1 >= 0) {
                        currColor = colors[currColorsIndex - 1];
                }
                else {
                        currColor = colors[colors.length - 1];
                }       
        }

	public boolean isOn() { return isOn; }
	public int getIntensity() { return intensityOfLight; }
	public Colors getColor() { return currColor; }

}

