import java.util.ArrayList;

public class WarGame extends Game {
    WarGame(String string, String other) {
        super(string, other);
    }


    void Gameplay() {
        Deck collection = new Deck();
        collection.Shuffle();
        while (!collection.deck.isEmpty()) {
            try {
                player1.inHand.deck.add(collection.drawCard());
                player2.inHand.deck.add(collection.drawCard());
            } catch (DeckException d) {
                System.out.println("The deck is empty!");
            }
        }
        int turn = 1;

        while (!hasWinner()) {
            if(turn > 6033) {
                System.out.println("No human in a whole planet would play so long the war game!!!");
                System.out.println(player1.name + "'s score: " + player1.getDeck().getCards().size());
                System.out.println(player2.name + "'s score: " + player2.getDeck().getCards().size());
                System.out.println("And the winner is... ");
                if(player1.getDeck().getCards().size() > player2.getDeck().getCards().size()) {
                    System.out.println(player1.name);
                }
                else if(player1.getDeck().getCards().size() < player2.getDeck().getCards().size()) {
                    System.out.println(player2.name);
                }
                else System.out.println("It's a draw! No one won (:");
                break;
            }

            System.out.println("Turn number: " + turn);
            playTurn();
            turn++;
        }
    }
    private boolean deckIsEmpty(Deck deck) {
        return deck.getCards().isEmpty();
    }

    private boolean hasWinner() {
        if (deckIsEmpty(player1.getDeck())) {
            System.out.println(player2.getName() + " won!");
            System.out.println(player2.inHand.deck.size());
            return true;
        } else if (deckIsEmpty(player2.getDeck())) {
            System.out.println(player1.getName() + " won!");
            System.out.println(player1.inHand.deck.size());
            return true;
        }
        return false;
    }

    private void playTurn() {
        try {
            Card card1 = player1.getDeck().drawCard();
            Card card2 = player2.getDeck().drawCard();

            System.out.println(player1.getName() + "'s card: " + card1.type + " " + card1.color);
            System.out.println(player2.getName() + "'s card: " + card2.type + " " + card2.color);

            int result = Compare(card1, card2);

            if (result == 1) {
                System.out.println(player1.getName() + " won this battle!");
                player1.getDeck().getCards().add(card1);
                player1.getDeck().getCards().add(card2);
            } else if (result == 2) {
                System.out.println(player2.getName() + " won this battle!");
                player2.getDeck().getCards().add(card2);
                player2.getDeck().getCards().add(card1);
            } else {
                playWar(card1, card2);
            }
        } catch (DeckException e) {
            System.out.println("An error occurred during the turn.");
        }

    }

    private void playWar(Card c1, Card c2) {
        try {
            ArrayList<Card> warCards = new ArrayList<>();
            warCards.add(c1);
            warCards.add(c2);

            System.out.println("War!");

            while (true) {
                warCards.add(player1.getDeck().drawCard());
                warCards.add(player2.getDeck().drawCard());

                Card card1 = player1.getDeck().drawCard();
                Card card2 = player2.getDeck().drawCard();

                System.out.println(player1.getName() + "'s card: " + card1.type + " " + card1.color);
                System.out.println(player2.getName() + "'s card: " + card2.type + " " + card2.color);

                warCards.add(card1);
                warCards.add(card2);

                int warResult = Compare(card1, card2);

                if (warResult == 1) {
                    System.out.println(player1.getName() + " won this war!");
                    player1.getDeck().getCards().addAll(warCards);
                    break;
                } else if (warResult == 2) {
                    System.out.println(player2.getName() + " won this war!");
                    player2.getDeck().getCards().addAll(warCards);
                    break;
                }
            }
        } catch(DeckException d) {
            System.out.println("number of player1's cards: " + player1.inHand.deck.size());
            System.out.println("number of player2's cards: " + player2.inHand.deck.size());
        }
    }

    int Compare(Card c, Card card) {
        if(c.type.getValue() > card.type.getValue()) return 1;
        else if(c.type.getValue() < card.type.getValue()) return 2;
        else return 0;
    }

}
