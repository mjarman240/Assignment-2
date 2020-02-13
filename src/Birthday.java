import java.util.Scanner;

public class Birthday {
    public static void main (String [] args) {
        // Variables
        boolean done = false;
        String [] childName = new String[65535];
        int childAge;
        String childToy;
        int i = 0;
        String tempValue;
        boolean verifyAge = false;

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
            childAge = userInput.nextInt();
            a.setAge(childAge);

            // Fix nextline behavior
            userInput.nextLine();

            // Prompt for toy wanted
            do {
                if (verifyAge) {
                    System.out.println("This toy may not be appropriate for your child. Do you wish to proceed?");
                    tempValue = userInput.nextLine();
                    if(tempValue.equalsIgnoreCase("no")) {
                        verifyAge = false;
                    }
                }
                if (!verifyAge) {
                    System.out.println("Choose a toy: a plushie, blocks, or a book");
                    childToy = userInput.nextLine();
                    a.setCost(childToy);
                    a.setToy(childToy);
                    verifyAge = true;
                }
            } while (a.ageOK());

            // Check if toy is age appropriate
            if (!a.ageOK()) {
                System.out.println("Do you wish to proceed with this toy? It may not be appropriate for thr age of your child");

            }

            // Ask if they want card
            System.out.println("Do you want a card");
            a.addCard(userInput.nextLine());

            // Ask if they want balloon
            System.out.println("Do you want a balloon");
            a.addBalloon(userInput.nextLine());

            // Ask if they want to finish program
            System.out.println("Do you wish to add another child");
            tempValue = userInput.nextLine();

            System.out.println(childName[i] + a.toString());

            if (tempValue.equalsIgnoreCase("no")) {
                done = true;
            }

            i++;
        } while (!done);
        System.out.println(a.getCost());
    }
}
