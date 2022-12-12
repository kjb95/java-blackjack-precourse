package utils;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Pattern;

public class Utils {

    public static final String NUMBER_REGEX = "^[0-9]+$";

    public static int countSpecificCharacters(String target, char specificCharacter) {
        return (int) target.chars()
                .filter(character -> character == specificCharacter)
                .count();
    }

    public static boolean isNumber(String input) {
        return Pattern.matches(NUMBER_REGEX, input);
    }

    public static <T> T exceptionHandlingRepeat(Supplier<T> supplier, Consumer<String> printErrorFunction) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            printErrorFunction.accept(e.getMessage());
            return exceptionHandlingRepeat(supplier, printErrorFunction);
        }
    }

    public static <T, R> R exceptionHandlingRepeat(Function<T, R> function, T argument, Consumer<String> printErrorFunction) {
        try {
            return function.apply(argument);
        } catch (IllegalArgumentException e) {
            printErrorFunction.accept(e.getMessage());
            return exceptionHandlingRepeat(function, argument, printErrorFunction);
        }
    }
}
