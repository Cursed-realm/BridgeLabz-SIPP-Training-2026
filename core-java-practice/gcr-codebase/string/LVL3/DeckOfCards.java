import java.util.Scanner;

public class DeckOfCards {
    public static String[] initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];
        int index = 0;
        
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index] = ranks[j] + " of " + suits[i];
                index++;
            }
        }
        
        return deck;
    }
    
    public static String[] shuffleDeck(String[] deck) {
        int n = deck.length;
        
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int)(Math.random() * (n - i));
            
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        
        return deck;
    }
    
    public static String[][] distributeCards(String[] deck, int numPlayers, int cardsPerPlayer) {
        int totalCardsNeeded = numPlayers * cardsPerPlayer;
        
        if (totalCardsNeeded > deck.length) {
            System.out.println("Not enough cards to distribute!");
            return null;
        }
        
        String[][] players = new String[numPlayers][cardsPerPlayer];
        int cardIndex = 0;
        
        for (int i = 0; i < numPlayers; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                players[i][j] = deck[cardIndex];
                cardIndex++;
            }
        }
        
        return players;
    }
    
    public static void printPlayersCards(String[][] players) {
        System.out.println("\n===== Player Cards =====");
        for (int i = 0; i < players.length; i++) {
            System.out.println("\nPlayer " + (i + 1) + ":");
            for (int j = 0; j < players[i].length; j++) {
                System.out.println("  " + (j + 1) + ". " + players[i][j]);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of players: ");
        int numPlayers = scanner.nextInt();
        
        System.out.print("Enter number of cards per player: ");
        int cardsPerPlayer = scanner.nextInt();
        
        String[] deck = initializeDeck();
        deck = shuffleDeck(deck);
        
        String[][] players = distributeCards(deck, numPlayers, cardsPerPlayer);
        
        if (players != null) {
            printPlayersCards(players);
        }
        
        scanner.close();
    }
}
