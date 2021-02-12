import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CardDeck {
    public static final int NUM_CARDS = 52;

    enum Rank {
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING,
        ACE;
    }

    enum Suit {
        CLUB,
        DIAMOND,
        HEART,
        SPADE;
    }

    private Deque<Card> cards = new ArrayDeque<Card>();

    public CardDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        List<Integer> indices = new ArrayList<Integer>();

        for (int i = 0; i < NUM_CARDS; i++) {
            indices.add(i);
        }


        Card[] cards = new Card[NUM_CARDS];
        
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                int indicesIdx = (int) (Math.random() * indices.size());
                int outputIdx = indices.get(indicesIdx);
                cards[outputIdx] = new Card(suit, rank);
                indices.remove(indicesIdx);
            }
        }

        for (Card card : cards) {
            this.cards.add(card);
        }
    }

    public String toString() {
        String retVal = "";

        for (Object card : this.cards.toArray()) {
            retVal += (Card) card + "\n";
        }

        return retVal;
    }

    private class Card {
        Suit suit;
        Rank rank;

        public Card(Suit suit, Rank rank) {
            this.suit = suit;
            this.rank = rank;
        }

        public String toString() {
            return this.rank + " of " + this.suit + "S";
        }
    }
}
