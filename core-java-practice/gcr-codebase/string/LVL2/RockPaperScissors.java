import java.util.Scanner;

public class RockPaperScissors {
    public static String getComputerChoice() {
        int choice = (int)(Math.random() * 3);
        if (choice == 0) return "Rock";
        else if (choice == 1) return "Paper";
        else return "Scissors";
    }
    
    public static String findWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equalsIgnoreCase(computerChoice)) {
            return "Tie";
        }
        
        if (playerChoice.equalsIgnoreCase("Rock") && computerChoice.equals("Scissors")) {
            return "Player";
        } else if (playerChoice.equalsIgnoreCase("Paper") && computerChoice.equals("Rock")) {
            return "Player";
        } else if (playerChoice.equalsIgnoreCase("Scissors") && computerChoice.equals("Paper")) {
            return "Player";
        } else {
            return "Computer";
        }
    }
    
    public static String[] getWinPercentage(int playerWins, int computerWins, int totalGames) {
        String[] result = new String[2];
        
        double playerPercentage = (playerWins * 100.0) / totalGames;
        double computerPercentage = (computerWins * 100.0) / totalGames;
        
        result[0] = String.format("%.2f", playerPercentage);
        result[1] = String.format("%.2f", computerPercentage);
        
        return result;
    }
    
    public static void displayResults(int playerWins, int computerWins, int ties, int totalGames, String[] percentages) {
        System.out.println("\n===== Final Results =====");
        System.out.println("Total Games: " + totalGames);
        System.out.println("Player Wins: " + playerWins);
        System.out.println("Computer Wins: " + computerWins);
        System.out.println("Ties: " + ties);
        System.out.println("\nPlayer Win Percentage: " + percentages[0] + "%");
        System.out.println("Computer Win Percentage: " + percentages[1] + "%");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of games to play: ");
        int numGames = scanner.nextInt();
        scanner.nextLine();
        
        int playerWins = 0;
        int computerWins = 0;
        int ties = 0;
        
        for (int i = 0; i < numGames; i++) {
            System.out.print("\nGame " + (i + 1) + " - Enter your choice (Rock/Paper/Scissors): ");
            String playerChoice = scanner.nextLine();
            String computerChoice = getComputerChoice();
            
            String winner = findWinner(playerChoice, computerChoice);
            
            System.out.println("Player: " + playerChoice + " | Computer: " + computerChoice);
            System.out.println("Result: " + winner);
            
            if (winner.equals("Player")) {
                playerWins++;
            } else if (winner.equals("Computer")) {
                computerWins++;
            } else {
                ties++;
            }
        }
        
        String[] percentages = getWinPercentage(playerWins, computerWins, numGames);
        displayResults(playerWins, computerWins, ties, numGames, percentages);
        
        scanner.close();
    }
}
