package domain;

import constant.Constant;
import java.util.function.Function;

public enum WinningResult {
    BLACKJACK(bettingMoney -> (int) (bettingMoney * Constant.BLACKJACK_DIVIDEND_YIELD)),
    WIN(bettingMoney -> bettingMoney.intValue()),
    DRAW(bettingMoney -> 0),
    LOSE(bettingMoney -> -bettingMoney.intValue());

    private Function<Double, Integer> function;

    WinningResult(Function<Double, Integer> function) {
        this.function = function;
    }

    public int computeRevenue(double bettingMoney) {
        return function.apply(bettingMoney);
    }
}
