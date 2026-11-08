
import java.util.Random;
import java.util.Scanner;

public class Game {

    private final Random random;
    private final Scanner scanner;
    private final ScoreManager scoreManager;

    private int roundNumber;

    public Game(Scanner scanner, ScoreManager scoreManager) {

        this.random = new Random();
        this.scanner = scanner;
        this.scoreManager = scoreManager;
        this.roundNumber = 0;
    }

    public void start() {

        boolean playAgain = true;

        while (playAgain) {

            roundNumber++;

            System.out.println("\n========== SELECT DIFFICULTY ==========");
            System.out.println("1. Easy   (1-50, 10 attempts)");
            System.out.println("2. Medium (1-100, 7 attempts)");
            System.out.println("3. Hard   (1-200, 5 attempts)");
            System.out.print("Choose difficulty: ");

            int choice = readInteger(scanner);

            int min = 1;
            int max;
            int maxAttempts;

            switch (choice) {

                case 1:
                    max = 50;
                    maxAttempts = 10;
                    System.out.println("\nDifficulty: EASY");
                    break;

                case 2:
                    max = 100;
                    maxAttempts = 7;
                    System.out.println("\nDifficulty: MEDIUM");
                    break;

                case 3:
                    max = 200;
                    maxAttempts = 5;
                    System.out.println("\nDifficulty: HARD");
                    break;

                default:
                    System.out.println("Invalid difficulty! Try again.");
                    roundNumber--;
                    continue;
            }

            int secretNumber = generateRandomNumber(min, max);

            int attempts = 0;
            boolean won = false;

            System.out.println("\nI have selected a number between "
                    + min + " and " + max + ".");

            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("\nEnter your guess: ");

                int guess = readInteger(scanner);

                if (guess < min || guess > max) {

                    System.out.println("Please enter a number between "
                            + min + " and " + max + ".");

                    continue;
                }

                attempts++;

                if (guess == secretNumber) {

                    System.out.println("\nCorrect! You guessed the number.");

                    won = true;

                    break;

                } else if (guess > secretNumber) {

                    System.out.println("Too High!");

                } else {

                    System.out.println("Too Low!");
                }

                System.out.println("Attempts remaining: "
                        + (maxAttempts - attempts));
            }

            if (won) {

                System.out.println("\nCongratulations!");

                System.out.println("You guessed the number in "
                        + attempts + " attempts.");

            } else {

                System.out.println("\nYou Lost!");

                System.out.println("The correct number was: "
                        + secretNumber);
            }

            scoreManager.updateScore(
                    roundNumber,
                    won,
                    attempts,
                    maxAttempts
            );

            scoreManager.displayRoundSummary(
                    roundNumber,
                    won,
                    attempts,
                    maxAttempts
            );

            System.out.print("\nDo you want to play again? (Y/N): ");

            playAgain = readYesOrNo();

        }
    }

    public int generateRandomNumber(int min, int max) {

        if (min > max) {

            throw new IllegalArgumentException(
                    "Minimum cannot be greater than maximum."
            );
        }

        return random.nextInt(max - min + 1) + min;
    }

    public boolean checkGuess(int guess, int secretNumber) {

        return guess == secretNumber;
    }

    public int readInteger(Scanner scanner) {

        while (!scanner.hasNextInt()) {

            System.out.println("Invalid input! Please enter an integer.");

            scanner.next();

            System.out.print("Try again: ");
        }

        return scanner.nextInt();
    }

    private boolean readYesOrNo() {

        while (true) {

            String input = scanner.next().trim();

            if (input.equalsIgnoreCase("Y")) {

                return true;

            } else if (input.equalsIgnoreCase("N")) {

                return false;
            }

            System.out.print("Invalid choice! Enter Y or N: ");
        }
    }
}
