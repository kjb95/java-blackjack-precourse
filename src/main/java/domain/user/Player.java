package domain.user;

import dto.CardDto;
import dto.PlayerCardDto;
import dto.PlayerCardResultDto;
import java.util.List;

/**
 * 게임 참여자를 의미하는 객체
 */
public class Player extends User {

    private final String name;
    private final double bettingMoney;

    public Player(String name, double bettingMoney) {
        this.name = name;
        this.bettingMoney = bettingMoney;
    }

    // TODO 추가 기능 구현

    public PlayerCardDto createPlayerCardDto() {
        List<CardDto> cardDtos = cardGroup.toDto();
        return new PlayerCardDto(name, cardDtos);
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

    public PlayerCardResultDto createPlayerCardResultDto() {
        List<CardDto> cardDtos = cardGroup.toDto();
        int score = cardGroup.computeScore();
        return new PlayerCardResultDto(name, cardDtos, score);
    }
}
