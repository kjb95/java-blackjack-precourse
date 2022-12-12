package domain.card;

import constant.Constant;
import dto.CardDto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CardGroup {

    private List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<CardDto> toDto() {
        return cards.stream()
                .map(Card::toDto)
                .collect(Collectors.toList());
    }

    public int computeScore() {
        int aceCount = countAce();
        int score = computeScoreRegardlessOfAce();
        while (score >= Constant.BURST_SCORE_MIN && aceCount > 0) {
            aceCount--;
            score -= Constant.ACE_SCORE_DIFF;
        }
        return score;
    }

    private int computeScoreRegardlessOfAce() {
        return cards.stream()
                .mapToInt(Card::getScore)
                .sum();
    }

    private int countAce() {
        return (int) cards.stream()
                .filter(Card::isAce)
                .count();
    }

}
