import java.util.Objects;

public class Card {
    Type type;
    Color color;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return type == card.type && color == card.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, color);
    }

    Card(Type t, Color c) {
        type = t;
        color = c;
    }
}
