package controller;

import dto.CardDto;
import dto.PlayerCardDto;
import java.util.List;
import service.BlackjackService;
import utils.Utils;
import view.InputView;
import view.OutputView;

public class BlackjackController {

    private BlackjackService blackjackService = new BlackjackService();

    public void run() {
        initPlayers();
    }

    private void initPlayers() {
        List<String> playerNames = Utils.exceptionHandlingRepeat(InputView::requestPlayerNames, OutputView::printErrorMessage);
        playerNames.forEach(this::initPlayer);
        OutputView.printInitCardDistribution(playerNames);
        CardDto cardDto = blackjackService.dealerInitCardDistribution();
        OutputView.printDealerInitCard(cardDto);
        List<PlayerCardDto> playerCardDtos = blackjackService.playersInitCardDistribution();
        OutputView.printPlayersInitCard(playerCardDtos);
    }

    private void initPlayer(String playerName) {
        int betAmount = Utils.exceptionHandlingRepeat(InputView::requestPlayerBetAmount, playerName, OutputView::printErrorMessage);
        blackjackService.addPlayer(playerName, betAmount);
    }


}
