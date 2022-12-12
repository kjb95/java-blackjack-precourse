package domain.user;

import domain.card.Card;
import domain.card.CardGroup;

public class User {

    protected final CardGroup cardGroup = new CardGroup();

    public void addCard(Card card) {
        cardGroup.addCard(card);
    }

    public CardGroup getCardGroup() {
        return cardGroup;
    }
}
