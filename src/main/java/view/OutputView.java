package view;

import constant.Constant;
import constant.Message;
import constant.MessageForm;
import dto.CardDto;
import dto.PlayerCardDto;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printErrorMessage(String message) {
        System.out.println();
        System.out.printf(MessageForm.ERROR_MESSAGE_FORM, message);
        System.out.println();
    }

    public static void printDealerInitCard(CardDto cardDto) {
        String symbol = cardDto.getSymbol();
        String type = cardDto.getType();
        System.out.printf(MessageForm.DEALER_INIT_CARD_FORM, symbol + type);
        System.out.println();
    }

    public static void printInitCardDistribution(List<String> playerNames) {
        String parsedPlayerNames = String.join(Constant.PLAYER_NAMES_JOIN_REGEX, playerNames);
        System.out.printf(MessageForm.INIT_CARD_DISTRIBUTION_FORM, parsedPlayerNames);
        System.out.println();
    }

    public static void printPlayersInitCard(List<PlayerCardDto> playerCardDtos) {
        playerCardDtos.forEach(OutputView::printPlayerInitCard);
        System.out.println();
    }

    private static void printPlayerInitCard(PlayerCardDto playerCardDto) {
        String playerName = playerCardDto.getPlayerName();
        List<CardDto> cardDtos = playerCardDto.getCardDtos();
        String cards = cardDtosToString(cardDtos);
        System.out.printf(MessageForm.PLAYER_INIT_CARD_FORM, playerName, cards);
        System.out.println();
    }

    private static String cardDtosToString(List<CardDto> cardDtos) {
        return cardDtos.stream()
                .map(OutputView::cardDtoToString)
                .collect(Collectors.joining(Message.CARDS_JOIN_REGEX));
    }

    private static String cardDtoToString(CardDto cardDto) {
        return cardDto.getSymbol() + cardDto.getType();
    }


}
