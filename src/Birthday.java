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
        JOptionPane.showMessageDialog(null, "Welcome to the Toy Company \nto choose gifts for young children");

        do {
            // Create toy object
            a = new Toy();

            // Prompt for child's name
            childName = JOptionPane.showInputDialog("Enter the name of the child");

            // Prompt for child's age
            childAge = Integer.parseInt(JOptionPane.showInputDialog("How old is the child?"));
            a.setAge(childAge);

            // Prompt for toy wanted and verify toy is valid
            do {
                childToy = JOptionPane.showInputDialog("Choose a toy: a plushie, blocks, or a book");
                a.setCost(childToy);
                a.setToy(childToy);
                if (a.getCost() == 0) {
                    JOptionPane.showMessageDialog(null, "Invalid choice\nPlease choose again");
                } else if (!a.ageOK()) {
                    if (JOptionPane.showInputDialog("Toy is not age-appropriate \nDo you want to buy a different toy? Yes or No").equalsIgnoreCase("no")) {
                        verifyAge = true;
                    }
                } else {
                        JOptionPane.showMessageDialog(null, "Good choice!");
                        verifyAge = true;
                }
            } while (!verifyAge);

            // Ask if they want card
            a.addCard(JOptionPane.showInputDialog("Do you want a card with the gift? Yes or No"));

            // Ask if they want balloon
            a.addBalloon(JOptionPane.showInputDialog("Do you want a balloon with the gift? Yes or No"));

            JOptionPane.showMessageDialog(null, "The gift for " + childName + a.toString());

            // Ask if they want to finish program
            if (JOptionPane.showInputDialog("Do you want to add another toy? Yes or No").equalsIgnoreCase("no")) {
                done = true;
            }

            // Add total cost to ongoing count
            totalCost += a.getCost();

            // Iterate value at end of loop
            i++;
        } while (!done);

        // Show total cost
        JOptionPane.showMessageDialog(null, "The total cost is $" + totalCost);

        // Print random order number and programmer name
        JOptionPane.showMessageDialog(null, "Your order number is " + randNum.nextInt(99999) + "\nProgrammer: Michael Jarman");
    }
}
