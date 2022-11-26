package domain.user;

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

    public List<String> collectCardToString() {
        return cards.collectCardToString();
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

}
