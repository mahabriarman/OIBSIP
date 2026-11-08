
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ScoreManager scoreManager = new ScoreManager();

        Game game = new Game(scanner, scoreManager);

        System.out.println("======================================");
        System.out.println("       NUMBER GUESSING GAME");
        System.out.println("======================================");

        System.out.println("Welcome to the Number Guessing Game!");

        boolean running = true;

        while (running) {

            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Start Game");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            int choice = game.readInteger(scanner);

            switch (choice) {

                case 1:
                    game.start();
                    break;

                case 2:
                    scoreManager.displaySummary();
                    System.out.println("\nThank you for playing!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }
}
