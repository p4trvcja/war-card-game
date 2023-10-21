import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    ArrayList<Card> deck;

    Deck() {
        deck = new ArrayList<>();
        for(Color c : Color.values()) {
            for(Type t : Type.values()) {
                deck.add(new Card(t, c));
            }
        }
    }
    Deck(int i) {
       deck = new ArrayList<>();
    }

    void Shuffle() {
        Collections.shuffle(this.deck);
    }

    Card drawCard() throws DeckException {
        if (deck.isEmpty()) throw new DeckException("The deck is empty!");
        return deck.remove(0);
    }

    ArrayList<Card> getCards() {
        return deck;
    }

}
