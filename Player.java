public class Player {
    String name;
    Deck inHand;

    Player(String s) {
        name = s;
        inHand = new Deck(0);
    }
    Deck getDeck() {
        return inHand;
    }

    String getName() {
        return name;
    }
}
