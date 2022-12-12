package domain.user;

import domain.card.Card;
import dto.CardDto;
import dto.PlayerCardDto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 게임 참여자를 의미하는 객체
 */
public class Player {

    private final String name;
    private final double bettingMoney;
    private final List<Card> cards = new ArrayList<>();

    public Player(String name, double bettingMoney) {
        this.name = name;
        this.bettingMoney = bettingMoney;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    // TODO 추가 기능 구현

    public PlayerCardDto createPlayerCardDto() {
        List<CardDto> cardDtos = cards.stream()
                .map(Card::toDto)
                .collect(Collectors.toList());
        return new PlayerCardDto(name, cardDtos);
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

}
