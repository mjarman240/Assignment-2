import java.util.Random;
import java.util.Scanner;

public class Birthday {
    public static void main (String [] args) {
        // Variables
        boolean done = false;
        boolean verifyAge = false;
        int childAge;
        int i = 0;
        int j = 0;
        double totalCost = 0;
        String childName;
        String childToy;
        String tempValue;
        String [] storedData = new String[65535];

        // Declare Object
        Toy a;

        // Temporary Scanner Object
        Scanner userInput = new Scanner(System.in);

        // RNG Object
        Random randNum = new Random();

        // Welcome user - dialog boxes to come soon
        System.out.println("Welcome to the toy factory.");

        do {
            // Create toy object
            a = new Toy();

            // Prompt for child's name
            System.out.println("Please enter the name of the child");
            childName = userInput.nextLine();

            // Prompt for child's age
            System.out.println("Please enter the age of the child");
            childAge = userInput.nextInt();
            a.setAge(childAge);

            // Fix nextLine behavior
            userInput.nextLine();

            // Prompt for toy wanted
            do {
                System.out.println("Choose a toy: a plushie, blocks, or a book");
                childToy = userInput.nextLine();
                a.setCost(childToy);
                a.setToy(childToy);
                if (!a.ageOK()) {
                    System.out.println("This toy may not be age appropriate. Do you want to buy another toy?");
                    if (userInput.nextLine().equalsIgnoreCase("no")) {
                        verifyAge = true;
                    }
                } else {
                    System.out.println("Good choice!");
                    verifyAge = true;
                }
            } while (!verifyAge);

            // Ask if they want card
            System.out.println("Do you want a card");
            a.addCard(userInput.nextLine());

            // Ask if they want balloon
            System.out.println("Do you want a balloon");
            a.addBalloon(userInput.nextLine());

            // Ask if they want to finish program
            System.out.println("Do you wish to add another child");
            if (userInput.nextLine().equalsIgnoreCase("no")) {
                done = true;
            }

            // Print value to string array
            storedData[i] = "The gift for " + childName + a.toString();

            // Add total cost to ongoing count
            totalCost += a.getCost();

            // Iterate value at end of loop
            i++;
        } while (!done);

        // Print data to console
        while (j < i) {
            System.out.println(storedData[j]);
            j++;
        }
        System.out.println("The total cost is $" + totalCost);

        // Print random order number
        System.out.println("Your order number is " + randNum.nextInt(99999));

        // Print programmer name
        System.out.println();
        System.out.println("Programmer: Michael Jarman");
    }
}
