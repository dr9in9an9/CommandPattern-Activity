package client;
import java.util.Scanner;

import remote.Remote;
import remote.RemoteGenerators;
import vendors.*;

public class Demo
{
    /**
     * Runs the demo program.
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        Television tv = new Television(100);
        SmartLight light = new SmartLight();
        Remote remote = RemoteGenerators.superRemote(tv, kb, light);
        remoteDemo(remote, kb);
    }

    /**
     * Allows a user to repeatedly press different buttons on a remote.
     * 
     * @param remote the remote to play with
     * @param userInput a method of getting input from the user
     */
    private static void remoteDemo(Remote remote, Scanner userInput)
    {
        int choice;
        String input;
        do {
            System.out.printf("\nSelect a button number or type exit:\n%s\nSelection: ", remote);
            input = userInput.nextLine();
            System.out.println();
            choice = convertInput(input, remote.getNumButtons(), 0);
            if (input.equals("exit"))
            {
                System.out.println("Goodbye!");
            }
            else if (choice == -1)
            {
                System.out.printf("Please enter a valid button selection: ");
            }
            else
            {
                remote.clickButton(choice);
            }
        } while (!input.equals("exit"));
    }

    /**
     * Checks a string to see if it is an int within a specific range.
     * 
     * @param input the string to convert
     * @param upper the highest valid number
     * @param lower the lowest valid number
     * @return the string converted to an int if it is valid or -1 if it is invalid
     */
    private static int convertInput(String input, int upper, int lower)
    {
        try
        {
            int output = Integer.parseInt(input);
            return output < lower || output > upper ? -1 : output;
        }
        catch (NumberFormatException e)
        {
            return -1;
        }
    }
}
