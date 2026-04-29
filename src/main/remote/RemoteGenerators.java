package remote;

import java.util.Scanner;

import vendors.*;

/**
 * Library of methods to create specific types of remotes.
 */
public class RemoteGenerators
{
    /**
     * Creates a remote for managing a tv.
     * Here the client connects the receiver (tv) to concrete commands (ie Power) and sets them in the invoker (Remote)
     * 
     * @param tv the tv to connect the remote to
     * @param userInput a method of getting input when subscribing or unsubsrcibing to channels.
     * @return the created remote.
     */
    public static Remote tvRemote(Television tv, Scanner userInput)
    {
        Remote tvRemote = new Remote(8);
        tvRemote.setButton(new Power(tv), 0);
        tvRemote.setButton(new ChannelListing(tv), 1);
        tvRemote.setButton(new Up(tv), 2);
        tvRemote.setButton(new Down(tv), 3);
        tvRemote.setButton(new Forward(tv), 4);
        tvRemote.setButton(new Backward(tv), 5);
        tvRemote.setButton(new Subscribe(tv, userInput), 6);
        tvRemote.setButton(new Unsubscribe(tv, userInput), 7);
        return tvRemote;
    }

    public static Remote lightRemote(SmartLight light)
    {
        Remote tvRemote = new Remote(5);
        tvRemote.setButton(new Power(light), 0);
        tvRemote.setButton(new Up(light), 1);
        tvRemote.setButton(new Down(light), 2);
        tvRemote.setButton(new Forward(light), 3);
        tvRemote.setButton(new Backward(light), 4);
        return tvRemote;
    }

    /*
    * Combines tvRemote and lightRemote into one, for least amount of buttons, simulating a real remote.
    */
    public static Remote superRemote(Television tv, Scanner userInput, SmartLight light)
    {
        Remote tvRemote = new Remote(8);
        tvRemote.setButton(new Power(tv, light), 0);
        tvRemote.setButton(new ChannelListing(tv), 1);
        tvRemote.setButton(new Up(tv, light), 2);
        tvRemote.setButton(new Down(tv, light), 3);
        tvRemote.setButton(new Forward(tv, light), 4);
        tvRemote.setButton(new Backward(tv, light), 5);
        tvRemote.setButton(new Subscribe(tv, userInput), 6);
        tvRemote.setButton(new Unsubscribe(tv, userInput), 7);
        return tvRemote;
    }
}
