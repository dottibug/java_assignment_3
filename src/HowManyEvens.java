// -----------------------------------------------------------------------------------------
// Author: Tanya Woodside
// COMP 1131 - Assignment 3, Question 2

// How Many Evens prompts the user for text of any length with any characters and returns how
// many even digits (0, 2, 4, 6, 8) the text contains. It also returns how many other characters
// the text contains. Users can enter text repeatedly until they choose to exit.
// -----------------------------------------------------------------------------------------

import java.util.Scanner;

public class HowManyEvens {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean anotherOne = true;
        int zeros = 0;
        int twos = 0;
        int fours = 0;
        int sixes = 0;
        int eights = 0;
        int otherChars = 0;
        String text = "";

        while (anotherOne) {
            System.out.println("\nHOW MANY EVEN DIGITS?");

            System.out.print("Enter some text: ");
            text = scan.nextLine();

            // Check each character
            for (int i = 0; i < text.length(); i++) {
                char character =  text.charAt(i);

                // Count even digits and other characters
                // Unicode 0=48, 2=50, 4=52, 6=54, 8=56
                switch (character) {
                    case (48):
                        zeros++;
                        break;
                    case (50):
                        twos++;
                        break;
                    case (52):
                        fours++;
                        break;
                    case (54):
                        sixes++;
                        break;
                    case (56):
                        eights++;
                        break;
                    default:
                        otherChars++;
                }
            }

            // Show results
            System.out.println("\n---Results---");
            System.out.println("Zeros: " + zeros);
            System.out.println("Twos: " + twos);
            System.out.println("Fours: " + fours);
            System.out.println("Sixes: " + sixes);
            System.out.println("Eights: " + eights);
            System.out.println("Others: " + otherChars);

            // Reset
            zeros = 0;
            twos = 0;
            fours = 0;
            sixes = 0;
            eights = 0;
            otherChars = 0;

            // Prompt user for another entry
            System.out.print("\nEnter another one? (Y/N): ");
            anotherOne = scan.nextLine().equalsIgnoreCase("y");
        }

      System.out.println("\nGoodbye!");
    }
}
