package view;

import constant.Constant;
import constant.ErrorMessage;
import constant.Message;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import utils.Utils;


public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> requestPlayerNames() {
        System.out.println(Message.REQUEST_PLAYER_NAMES);
        String playerNames = scanner.nextLine();
        return parsePlayerNames(playerNames);
    }

    private static List<String> parsePlayerNames(String playerNames) {
        List<String> parsedPlayerNames = Arrays.stream(playerNames.split(Constant.PLAYER_NAMES_SPLIT_REGEX))
                .collect(Collectors.toList());
        validatePlayerNames(playerNames, parsedPlayerNames);
        return parsedPlayerNames;
    }

    private static void validatePlayerNames(String playerNames, List<String> parsedPlayerNames) {
        int countPlayerNamesSplitRegex = Utils.countSpecificCharacters(playerNames, Constant.PLAYER_NAMES_SPLIT_REGEX.charAt(0));
        if (countPlayerNamesSplitRegex + 1 != parsedPlayerNames.size()) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_PLAYER_NAME);
        }
        boolean hasEmptyName = parsedPlayerNames.stream()
                .anyMatch(playerName -> playerName.length() == 0);
        if (hasEmptyName) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_PLAYER_NAME);
        }
    }
}
