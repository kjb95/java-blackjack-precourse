package domain.user;

import domain.card.Card;
import domain.card.CardGroup;
import dto.CardDto;
import dto.PlayerCardDto;
import java.util.List;

/**
 * 게임 참여자를 의미하는 객체
 */
public class Player {

    private final String name;
    private final double bettingMoney;
    private final CardGroup cardGroup = new CardGroup();

    public Player(String name, double bettingMoney) {
        this.name = name;
        this.bettingMoney = bettingMoney;
    }

    public void addCard(Card card) {
        cardGroup.addCard(card);
    }

    // TODO 추가 기능 구현

    public PlayerCardDto createPlayerCardDto() {
        List<CardDto> cardDtos = cardGroup.toDto();
        return new PlayerCardDto(name, cardDtos);
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

}
