
public class ScoreManager {

    private int totalRounds;
    private int totalWins;
    private int totalLosses;
    private int totalAttempts;

    public ScoreManager() {

        totalRounds = 0;
        totalWins = 0;
        totalLosses = 0;
        totalAttempts = 0;
    }

    public void updateScore(
            int roundNumber,
            boolean won,
            int attempts,
            int maxAttempts) {

        totalRounds++;

        totalAttempts += attempts;

        if (won) {

            totalWins++;

        } else {

            totalLosses++;
        }
    }

    public void displayRoundSummary(
            int roundNumber,
            boolean won,
            int attempts,
            int maxAttempts) {

        System.out.println("\n========== ROUND SUMMARY ==========");

        System.out.println("Round Number: " + roundNumber);

        System.out.println("Result: " + (won ? "Won" : "Lost"));

        System.out.println("Attempts Used: " + attempts);

        System.out.println("Maximum Attempts: " + maxAttempts);

        if (won) {

            System.out.println("Performance: Successfully guessed!");

        } else {

            System.out.println("Performance: Attempts exhausted.");
        }

        System.out.println("===================================");
    }

    public void displaySummary() {

        System.out.println("\n========== GAME STATISTICS ==========");

        System.out.println("Total Rounds Played: " + totalRounds);

        System.out.println("Total Wins: " + totalWins);

        System.out.println("Total Losses: " + totalLosses);

        System.out.println("Total Attempts: " + totalAttempts);

        System.out.println("=====================================");
    }
}
