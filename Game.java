public class Game {
    Player player1;
    Player player2;
    Deck deck;

    Game(String string, String other) {
        player1 = new Player(string);
        player2 = new Player(other);
        deck = new Deck();
    }
}
