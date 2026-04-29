package remote;
/**
 * A generic remote class that assigns actions to buttons.
 * 
 * @author Willow Sapphire
 * @version Fall 2022
 */
public class Remote
{
    /**
     * The list of actions for each button.
     */
    private Action[] buttons;
    
    /**
     * Creates a new remote with a given number of empty buttons.
     * 
     * @param numButtons the number of buttons on the remote.
     */
    public Remote(int numButtons)
    {
        buttons = new Action[numButtons < 0 ? 0 : numButtons];
        for (int i = 0; i < buttons.length; i++)
        {
            buttons[i] = Action.NULL;
        }
    }

    /**
     * Runs the action of a specified button.
     * 
     * @param button the number of the button to press.
     * @return true if the action is succesfully run, false otherwise.
     */
    public boolean clickButton(int button)
    {
        if (invalidButton(button))
        {
            System.out.printf("Invalid button choice: %d. Valid buttons are 0 - %d\n", button, buttons.length - 1);
            return false;
        }
        return buttons[button].performAction();
    }

    /**
     * Sets the action for a particular button.
     * 
     * @param action the action to perform when the button is pressed
     * @param button the button's number on the remote
     * @return true if the button is successfully set, false otherwise
     */
    public boolean setButton(Action action, int button)
    {
        if (invalidButton(button))
        {
            System.out.printf("Invalid button choice: %d. Valid buttons are 0 - %d\n", button, buttons.length - 1);
            return false;
        }
        buttons[button] = action;
        return true;
    }

    /**
     * Sets the action for a particular button to an empty action
     * 
     * @param button the button's number on the remote
     * @return true if the button is successfully set, false otherwise
     */
    public boolean resetButton(int button)
    {
        return setButton(Action.NULL, button);
    }

    /**
     * Setter for the entire array of buttons.
     * This will get rid of all existing buttons.
     * Buttons at indexes greater than the number of buttons will not be used.
     * If fewer actions are provided than the number of buttons, the greater buttons will not change.
     * 
     * @param buttons the actions to add to the buttons.
     */
    public void setAllButtons(Action[] buttons)
    {
        for (int i = 0; i < this.buttons.length && i < buttons.length; i++)
        {
            this.buttons[i] = buttons[i];
        }
    }

    /**
     * Getter for the number of buttons on the remote.
     * 
     * @return the number of buttons on the remote
     */
    public int getNumButtons()
    {
        return this.buttons.length;
    }

    /**
     * Checks if a button is invalid.
     * 
     * @param button the button to check
     * @return true if the button is valid, false otherwise
     */
    public boolean invalidButton(int button)
    {
        return button < 0 || button >= buttons.length;
    }

    /**
     * Prints all of the buttons on the remote and their actions.
     */
    public String toString()
    {
        String output = "";
        int halfButtons = (int) Math.ceil(buttons.length / 2.0);
        for (int i = 0; i < halfButtons; i++)
        {
            output += String.format("%d) %-22s", i, buttons[i]);
            if (i + halfButtons < buttons.length)
            {
                output += String.format("%d) %s\n", i + halfButtons, buttons[i + halfButtons]);
            }
        }
        return output;
    }
}
