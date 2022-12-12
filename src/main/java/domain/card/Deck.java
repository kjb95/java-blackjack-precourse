package domain.card;

import java.util.List;
import java.util.Stack;

public class Deck {

    private final Stack<Card> cards = new Stack<>();

    public Deck() {
        List<Card> cards = CardFactory.create();
        cards.forEach(this.cards::add);
    }

    public Card draw() {
        return cards.pop();
    }
}
