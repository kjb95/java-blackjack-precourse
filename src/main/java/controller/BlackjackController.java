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
        List<String> playerNames = initPlayers();
        drawMoreCard(playerNames);
    }

    private List<String> initPlayers() {
        List<String> playerNames = Utils.exceptionHandlingRepeat(InputView::requestPlayerNames, OutputView::printErrorMessage);
        playerNames.forEach(this::initPlayer);
        OutputView.printInitCardDistribution(playerNames);
        CardDto cardDto = blackjackService.dealerInitCardDistribution();
        OutputView.printDealerInitCard(cardDto);
        List<PlayerCardDto> playerCardDtos = blackjackService.playersInitCardDistribution();
        OutputView.printPlayersInitCard(playerCardDtos);
        return playerNames;
    }

    private void initPlayer(String playerName) {
        int betAmount = Utils.exceptionHandlingRepeat(InputView::requestPlayerBetAmount, playerName, OutputView::printErrorMessage);
        blackjackService.addPlayer(playerName, betAmount);
    }

    private void drawMoreCard(List<String> playerNames) {
        playerNames.forEach(this::drawMoreCard);
    }

    private void drawMoreCard(String playerName) {
        boolean isDrawCard = Utils.exceptionHandlingRepeat(InputView::requestDrawMoreCard, playerName, OutputView::printErrorMessage);
        if (!isDrawCard) {
            return;
        }
        PlayerCardDto playerCardDto = blackjackService.drawCard(playerName);
        OutputView.printPlayerCard(playerCardDto);
        drawMoreCard(playerName);
    }
}
