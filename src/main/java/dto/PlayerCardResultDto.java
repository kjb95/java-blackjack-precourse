package dto;

import java.util.List;

public class PlayerCardResultDto {

    private final String name;
    private final List<CardDto> cards;
    private final int score;

    public PlayerCardResultDto(String name, List<CardDto> cards, int score) {
        this.name = name;
        this.cards = cards;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public List<CardDto> getCards() {
        return cards;
    }

    public int getScore() {
        return score;
    }
}
