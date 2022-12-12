package view;

import constant.ErrorMessage;
import java.util.Arrays;

public enum DrawMoreCardSelection {
    YES("y"),
    NO("n");

    private final String selection;

    DrawMoreCardSelection(String selection) {
        this.selection = selection;
    }

    public static void validate(String selection) {
        boolean isAnyMatch = Arrays.stream(DrawMoreCardSelection.values())
                .anyMatch(drawMoreCardSelection -> drawMoreCardSelection.selection.equals(selection));
        if (!isAnyMatch) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_SELECTION);
        }
    }

    public String getSelection() {
        return selection;
    }
}
