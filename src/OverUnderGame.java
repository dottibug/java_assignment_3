// -----------------------------------------------------------------------------------------
// Author: Tanya Woodside
// COMP 1131 - Assignment 3, Question 1

// Over-under is a guessing game in which a player tries to guess the random secret letter.
// Players can guess using lowercase or uppercase letters. The total number of guesses is
// revealed when the player correctly guesses the secret letter. Players can quit a game by
// typing "quit" (case doesn't matter), or they can play multiple games.
// -----------------------------------------------------------------------------------------

import java.util.Random;
import java.util.Scanner;

public class OverUnderGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean play = true;
        boolean win = false;

        String guess = "";
        int count = 0;

        // Game loop
        while (play) {

            // Generate random letter
            Random rng = new Random();
            char c = (char) ('a' + rng.nextInt(26));

            // Convert random letter to String to easily compare it to guesses
            String secretLetter = String.valueOf(c);

            System.out.println("\nTHE OVER-UNDER GAME");

            // Guess loop
            while (!win) {
                System.out.print("Guess the letter: ");
                guess = scan.next().toLowerCase();

                // Break guess loop if user quits
                if (guess.equalsIgnoreCase("quit")) {
                    System.out.println("Thanks for playing!");
                    break;
                }

                // Validate and evaluate guess
                // A valid guess is a unicode letter between a (97) and z (122), inclusive
                boolean validGuess = guess.length() == 1 &&
                        guess.charAt(0) >= 97 && guess.charAt(0) <= 122;

                if (!validGuess) {
                    System.out.println("Oops! Your guess must be a single letter.\n");
                } else {
                    count++;

                    int result = guess.compareTo(secretLetter);
                    String guessMsg = "Your guess is ";

                    if (result == 0) {
                        System.out.println(guessMsg + "correct!");
                        win = true;
                    } else if (result < 0) {
                        System.out.println(guessMsg + "under.\n");
                    } else {
                        System.out.println(guessMsg + "over.\n");
                    }
                }
            }

            // Handle win
            if (win) System.out.println("\nYou guessed correctly in " + count + (count == 1 ?
                    " guess." : " guesses."));

            // Reset game
            win = false;
            count = 0;
            guess = "";

            // Prompt user for another game
            System.out.println("\nPlay again? (y/n)");
            play = scan.next().equalsIgnoreCase("y");
        }
    }
}