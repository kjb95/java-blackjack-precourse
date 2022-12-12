package controller;

import java.util.List;
import utils.Utils;
import view.InputView;
import view.OutputView;

public class BlackjackController {

    public void run() {
        initPlayer();
    }

    private void initPlayer() {
        List<String> playerNames = Utils.exceptionHandlingRepeat(InputView::requestPlayerNames, OutputView::printErrorMessage);
        playerNames.forEach(this::initPlayer);
    }

    private void initPlayer(String playerName) {
        int betAmount = Utils.exceptionHandlingRepeat(InputView::requestPlayerBetAmount, playerName, OutputView::printErrorMessage);

    }

}
