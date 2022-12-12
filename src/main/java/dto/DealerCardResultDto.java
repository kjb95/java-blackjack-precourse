package dto;

import java.util.List;

public class DealerCardResultDto {

    private final List<CardDto> cards;
    private final int score;

    public DealerCardResultDto(List<CardDto> cards, int score) {
        this.cards = cards;
        this.score = score;
    }

    public List<CardDto> getCards() {
        return cards;
    }

    public int getScore() {
        return score;
    }
}
