package domain.user;

import domain.card.Card;
import domain.card.CardGroup;

/**
 * 게임 딜러를 의미하는 객체
 */
public class Dealer {

    private final CardGroup cardGroup = new CardGroup();

    public Dealer() {
    }

    public void addCard(Card card) {
        cardGroup.addCard(card);
    }

    // TODO 추가 기능 구현
}
