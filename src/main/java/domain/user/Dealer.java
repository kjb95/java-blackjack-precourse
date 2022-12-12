package domain.user;

import constant.Constant;

/**
 * 게임 딜러를 의미하는 객체
 */
public class Dealer extends User {

    // TODO 추가 기능 구현

    public boolean isDrawMoreCard() {
        return cardGroup.computeScore() <= Constant.DEALER_DRAW_MORE_CARD_LEVEL;
    }
}
