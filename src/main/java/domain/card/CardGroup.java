package domain.card;

import constant.Constant;
import domain.WinningResult;
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

    public WinningResult computeWinningResult(CardGroup target) {
        if (isBlackjack() && !target.isBlackjack()) {
            return WinningResult.BLACKJACK;
        }
        if (isBurst()) {
            return WinningResult.LOSE;
        }
        if (target.isBurst()) {
            return WinningResult.WIN;
        }
        if (computeScore() > target.computeScore()) {
            return WinningResult.WIN;
        }
        if (computeScore() < target.computeScore()) {
            return WinningResult.LOSE;
        }
        return WinningResult.DRAW;
    }

    private boolean isBlackjack() {
        return computeScore() == Constant.BLACK_SCORE && cards.size() == Constant.BLACK_CARD_COUNT;
    }

    private boolean isBurst() {
        return computeScore() >= Constant.BURST_SCORE_MIN;
    }

}
