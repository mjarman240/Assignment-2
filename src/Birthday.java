import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class Birthday {
    public static void main (String [] args) {
        // Variables
        boolean done = false, verifyAge = false;
        int childAge, i = 0;
        double totalCost = 0;
        String childName, childToy;

        // Declare Object
        Toy a;

        // Temporary Scanner Object
        Scanner userInput = new Scanner(System.in);

        // RNG Object
        Random randNum = new Random();

        // Welcome dialog
        JOptionPane.showMessageDialog(null, "Welcome to the toy factory!");

        do {
            // Create toy object
            a = new Toy();

            // Prompt for child's name
            childName = JOptionPane.showInputDialog("Please enter the name of the child");

            // Prompt for child's age
            childAge = Integer.parseInt(JOptionPane.showInputDialog("Please enter the age of the child"));
            a.setAge(childAge);

            // Prompt for toy wanted
            do {
                childToy = JOptionPane.showInputDialog("Choose a toy: a plushie, blocks, or a book");
                a.setCost(childToy);
                a.setToy(childToy);
                if (!a.ageOK()) {
                    if (JOptionPane.showInputDialog("This toy may not be age appropriate. Do you want to buy another toy?").equalsIgnoreCase("no")) {
                        verifyAge = true;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Good choice!");
                    verifyAge = true;
                }
            } while (!verifyAge);

            // Ask if they want card
            a.addCard(JOptionPane.showInputDialog("Do you want a card?"));

            // Ask if they want balloon
            a.addBalloon(JOptionPane.showInputDialog("Do you want a balloon?"));

            JOptionPane.showMessageDialog(null, "The gift for " + childName + a.toString());

            // Ask if they want to finish program
            if (JOptionPane.showInputDialog("Do you wish to add another child?").equalsIgnoreCase("no")) {
                done = true;
            }

            // Add total cost to ongoing count
            totalCost += a.getCost();

            // Iterate value at end of loop
            i++;
        } while (!done);

        // Show total cost
        JOptionPane.showMessageDialog(null, "The total cost is $" + totalCost);

        // Print random order number
        JOptionPane.showMessageDialog(null, "Your order number is " + randNum.nextInt(99999));

        // Print programmer name
        JOptionPane.showMessageDialog(null, "Programmer: Michael Jarman");
    }
}
