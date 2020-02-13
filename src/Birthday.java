import java.util.Scanner;

public class Birthday {
    public static void main (String [] args) {
        // Variables
        boolean done = false;
        boolean verifyAge = false;
        int childAge;
        int i = 0;
        int totalCost = 0;
        String childName;
        String childToy;
        String tempValue;
        String [] storedData = new String[65535];

        // Create Object
        Toy a = new Toy();

        // Temporary Scanner Object
        Scanner userInput = new Scanner(System.in);

        // Welcome user - dialog boxes to come soon
        System.out.println("Welcome to the toy factory.");

        do {

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
                /* CURRENTLY BROKEN - COMMENTED OUT UNTIL FURTHER NOTICE
                if (verifyAge) {
                    System.out.println("This toy may not be age appropriate for your child. Do you wish to proceed?");
                    tempValue = userInput.nextLine();
                    if (tempValue.equalsIgnoreCase("no")) {
                        verifyAge = false;
                    } else {
                        verifyAge = true;
                    }
                }
                */
                if (!a.ageOK()) {
                    System.out.println("Choose a toy: a plushie, blocks, or a book");
                    childToy = userInput.nextLine();
                    a.setCost(childToy);
                    a.setToy(childToy);
                    verifyAge = true;
                }
                System.out.println(verifyAge);
            } while (!verifyAge);

            // Ask if they want card
            System.out.println("Do you want a card");
            a.addCard(userInput.nextLine());

            // Ask if they want balloon
            System.out.println("Do you want a balloon");
            a.addBalloon(userInput.nextLine());

            // Ask if they want to finish program
            System.out.println("Do you wish to add another child");
            tempValue = userInput.nextLine();

            // Print value to string array
            storedData[i] = childName + a.toString();

            if (tempValue.equalsIgnoreCase("no")) {
                done = true;
            }

            totalCost += a.getCost();

            i++;
        } while (!done);

        // Print data to console
        int j = 0;
        while (j < i) {
            System.out.println(storedData[j]);
            j++;
        }
        System.out.println("The total cost is $" + totalCost);
    }
}
