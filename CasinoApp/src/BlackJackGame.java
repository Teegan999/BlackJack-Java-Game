
import java.util.ArrayList;

public class BlackJackGame {

    private Deck deck;
    private ArrayList<Card> playerHand;
    private ArrayList<Card> dealerHand;

    public BlackJackGame() {
        deck = new Deck();
        playerHand = new ArrayList<>();
        dealerHand = new ArrayList<>();
    }

    public void startGame() {
        playerHand.clear();
        dealerHand.clear();
        deck = new Deck(); // fresh deck

        // deal 2 cards each
        playerHand.add(deck.drawCard());
        playerHand.add(deck.drawCard());
        dealerHand.add(deck.drawCard());
        dealerHand.add(deck.drawCard());
    }

    public void playerHit() {
        playerHand.add(deck.drawCard());
    }

    public void dealerPlay() {
        while (calculateTotal(dealerHand) < 17) {
            dealerHand.add(deck.drawCard());
        }
    }

    public int calculateTotal(ArrayList<Card> hand) {
        int total = 0;
        int aces = 0;

        for (Card c : hand) {
            total += c.getValue();
            if (c.getRank().equals("A")) {
                aces++;
            }
        }

        // fix Aces from 11 → 1 if needed
        while (total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }

        return total;
    }

    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    public ArrayList<Card> getDealerHand() {
        return dealerHand;
    }
}
