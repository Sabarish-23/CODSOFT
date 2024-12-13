/*
TASK 1
NUMBER GAME
 1. Generate a random number within a specified range, such as 1 to 100.
 2. Prompt the user to enter their guess for the generated number.
 3. Compare the user's guess with the generated number and provide feedback on whether the guess
 is correct, too high, or too low.
 4. Repeat steps 2 and 3 until the user guesses the correct number.
 You can incorporate additional details as follows:
 5. Limit the number of attempts the user has to guess the number.
 6. Add the option for multiple rounds, allowing the user to play again.
 7. Display the user's score, which can be based on the number of attempts taken or rounds won.
*/

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");

        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            int generatedNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attemptsLeft = maxAttempts;
            System.out.println("\nI'm thinking of a number between " + lowerBound + " and " + upperBound + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess (" + attemptsLeft + " attempts left): ");
                try {
                    int guess = scanner.nextInt();

                    if (guess < lowerBound || guess > upperBound) {
                        System.out.println("Please enter a number between " + lowerBound + " and " + upperBound + ".");
                        continue;
                    }

                    if (guess == generatedNumber) {
                        System.out.println("Congratulations! You guessed the correct number.");
                        score++;
                        break;
                    } else if (guess < generatedNumber) {
                        System.out.println("Too low! Try again.");
                    } else {
                        System.out.println("Too high! Try again.");
                    }

                    attemptsLeft--;
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); // Clear invalid input
                }
            }

            if (attemptsLeft == 0) {
                System.out.println("Out of attempts! The correct number was " + generatedNumber + ".");
            }

            System.out.println("Your current score is: " + score);
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgainResponse = scanner.next().trim().toLowerCase();
            playAgain = playAgainResponse.equals("yes") || playAgainResponse.equals("y");
        }

        System.out.println("\nThanks for playing! Your final score is: " + score);
        scanner.close();
    }
}

/*
SAMPLE INPUT/OUTPUT:
Welcome to the Number Guessing Game!

I'm thinking of a number between 1 and 100.
You have 10 attempts to guess it.
Enter your guess (10 attempts left): 8
Too low! Try again.
Enter your guess (9 attempts left): 9
Too low! Try again.
Enter your guess (8 attempts left): 70
Too high! Try again.
Enter your guess (7 attempts left): 50
Too low! Try again.
Enter your guess (6 attempts left): 60
Too low! Try again.
Enter your guess (5 attempts left): 65
Too high! Try again.
Enter your guess (4 attempts left): 63
Too high! Try again.
Enter your guess (3 attempts left): 61
Too low! Try again.
Enter your guess (2 attempts left): 62
Congratulations! You guessed the correct number.
Your current score is: 1
Do you want to play another round? (yes/no): 
=== Session Ended. Please Run the code again ===
  */
