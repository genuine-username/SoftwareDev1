package Week11;

public class Exceptions {
    public static void main(String[] args) {
        System.out.println("\nCODING TESTS");

        // Demonstrate out of bounds error
        // Create an array with 1 item
        int[] arrayError = {0};

        // Attempt to access the second item in an array with length 1
        System.out.println("\nAttempting to print item in array...");
        try {
            // Try to print out item 1
            System.out.println(String.valueOf(arrayError[1]));
        } catch (Exception e) {
            // If it fails, tell the user that an error occurred
            System.out.println("It appears that the item asked for in the array does not exist.");
        }

        // Try to divide 1 by 0
        System.out.println("\nAttempting to divide one number by another...");
        try {
            System.out.println(String.valueOf(1/0));
        } catch (Exception e) {
            System.out.println("Sorry, it appears that 0 cannot be divided by 1!");
        }

        System.out.println("\nTests complete. Exiting program.");
    }
}
