package controller;

import dto.CardDto;
import java.util.List;
import service.BlackjackService;
import utils.Utils;
import view.InputView;
import view.OutputView;

public class BlackjackController {

    private BlackjackService blackjackService = new BlackjackService();

    public void run() {
        initPlayer();
        initCardDistribution();
    }

    private void initPlayer() {
        List<String> playerNames = Utils.exceptionHandlingRepeat(InputView::requestPlayerNames, OutputView::printErrorMessage);
        playerNames.forEach(this::initPlayer);
    }

    private void initPlayer(String playerName) {
        int betAmount = Utils.exceptionHandlingRepeat(InputView::requestPlayerBetAmount, playerName, OutputView::printErrorMessage);
        blackjackService.addPlayer(playerName, betAmount);
    }

    private void initCardDistribution() {
        CardDto cardDto = blackjackService.dealerInitCardDistribution();
    }


}
