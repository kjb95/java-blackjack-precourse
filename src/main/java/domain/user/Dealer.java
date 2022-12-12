package domain.user;

import constant.Constant;
import dto.CardDto;
import dto.DealerCardResultDto;
import java.util.List;

/**
 * 게임 딜러를 의미하는 객체
 */
public class Dealer extends User {

    // TODO 추가 기능 구현

    public boolean isDrawMoreCard() {
        return cardGroup.computeScore() <= Constant.DEALER_DRAW_MORE_CARD_LEVEL;
    }

    public DealerCardResultDto toDto() {
        List<CardDto> cardDtos = cardGroup.toDto();
        int score = cardGroup.computeScore();
        return new DealerCardResultDto(cardDtos, score);
    }
}
