import org.ietf.jgss.GSSContext;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*        Task 3
        Deck collection = new Deck();
        Deck collection2 = new Deck();
        HashSet<Card> hashSet = new HashSet<>(collection.deck); //52 cards
        hashSet.addAll(collection2.deck); //before override 104 cards, now 52
        System.out.println(hashSet.size());
*/
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first player's name: ");
        String s = scanner.nextLine();
        System.out.println("Enter second player's name: ");
        String t = scanner.nextLine();
        WarGame game = new WarGame(s, t);
        game.Gameplay();
    }
}