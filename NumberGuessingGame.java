import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int rounds = 3;
        int maxAttempts = 5; 
        int score = 0;

        for (int round = 1; round <= rounds; round++) {
            System.out.println("Round " + round + " of " + rounds);
            int numberToGuess = random.nextInt(100) + 1;
            boolean guessedCorrectly = false;

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                System.out.println("Attempt " + attempt + " of " + maxAttempts + ". Enter your guess:");
                int userGuess = scanner.nextInt();

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score++;
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all attempts. The correct number was " + numberToGuess);
            }
        }

        System.out.println("Game over! Your score: " + score + " out of " + rounds);
        scanner.close();
    }
}
