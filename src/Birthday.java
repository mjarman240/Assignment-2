import java.util.Scanner;

public class Birthday {
    public static void main (String [] args) {
        // Variables
        boolean done = false;
        String [] childName = new String[65535];
        int [] childAge = new int[65535];
        String [] childToy = new String[65535];
        int i = 0;
        String tempValue;

        // Create Object
        Toy a = new Toy();

        // Temporary Scanner Object
        Scanner userInput = new Scanner(System.in);

        // Welcome user - dialog boxes to come soon
        System.out.println("Welcome to the toy factory.");

        do {

            // Prompt for child's name
            System.out.println("Please enter the name of the child");
            childName[i] = userInput.nextLine();

            // Prompt for child's age
            System.out.println("Please enter the age of the child");
            childAge[i] = userInput.nextInt();
            a.setAge(childAge[i]);

            // Prompt for toy wanted
            System.out.println("Choose a toy: a plushie, blocks, or a book");
            childToy[i] = userInput.nextLine();
            a.setToy(childToy[i]);

            // Ask if they want card
            System.out.println("Do you want a card");
            a.addCard(userInput.nextLine());

            // Ask if they want balloon
            System.out.println("Do you want a balloon");
            a.addBalloon(userInput.nextLine());

            // Ask if they want to finish program
            System.out.println("Do you wish to add another child");
            tempValue = userInput.nextLine();
            if (tempValue.equalsIgnoreCase("no")) {
                done = true;
            }

            i++;
        } while (!done);
    }
}
