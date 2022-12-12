package view;

import constant.Constant;
import constant.MessageForm;
import dto.CardDto;
import java.util.List;

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
}
