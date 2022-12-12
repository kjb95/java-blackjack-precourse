package view;

import constant.Constant;
import constant.Message;
import constant.MessageForm;
import dto.CardDto;
import dto.DealerCardResultDto;
import dto.PlayerCardDto;
import dto.PlayerCardResultDto;
import dto.RevenueDto;
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
        playerCardDtos.forEach(OutputView::printPlayerCard);
        System.out.println();
    }

    public static void printPlayerCard(PlayerCardDto playerCardDto) {
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


    public static void printDealerDrawMoreCard() {
        System.out.println(Message.DEALER_DRAW_MORE_CARD);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printDealerCardResult(DealerCardResultDto dealerCardResultDto) {
        List<CardDto> cardDtos = dealerCardResultDto.getCards();
        int score = dealerCardResultDto.getScore();
        String cards = cardDtosToString(cardDtos);
        System.out.println();
        System.out.printf(MessageForm.DEALER_CARD_RESULT_FROM, cards, score);
        System.out.println();
    }

    public static void printPlayersCardResult(List<PlayerCardResultDto> playerCardResultDtos) {
        playerCardResultDtos.forEach(OutputView::printPlayerCardResult);
    }

    public static void printPlayerCardResult(PlayerCardResultDto playerCardResultDto) {
        String name = playerCardResultDto.getName();
        List<CardDto> cardDtos = playerCardResultDto.getCards();
        String cards = cardDtosToString(cardDtos);
        int score = playerCardResultDto.getScore();
        System.out.printf(MessageForm.PLAYER_CARD_RESULT_FORM, name, cards, score);
        System.out.println();
    }

    public static void printRevenueResult(List<RevenueDto> revenueResultDtos) {
        int dealerRevenue = computeDealerRevenue(revenueResultDtos);
        System.out.println();
        System.out.printf(MessageForm.TITLE_MESSAGE_FORM, Message.FINAL_REVENUE);
        System.out.println();
        System.out.printf(MessageForm.DEALER_REVENUE_FORM, dealerRevenue);
        System.out.println();
        revenueResultDtos.forEach(OutputView::printPlayerRevenueResult);
    }

    private static int computeDealerRevenue(List<RevenueDto> revenueResultDtos) {
        return -revenueResultDtos.stream()
                .mapToInt(revenueResultDto -> revenueResultDto.getRevenue())
                .sum();
    }

    private static void printPlayerRevenueResult(RevenueDto revenueDto) {
        String name = revenueDto.getName();
        int revenue = revenueDto.getRevenue();
        System.out.printf(MessageForm.PLAYER_REVENUE_FORM, name, revenue);
        System.out.println();
    }
}
