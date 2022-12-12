package utils;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Utils {
    public static int countSpecificCharacters(String target, char specificCharacter) {
        return (int) target.chars()
                .filter(character -> character == specificCharacter)
                .count();
    }

    public static <T> T exceptionHandlingRepeat(Supplier<T> supplier, Consumer<String> printErrorFunction) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            printErrorFunction.accept(e.getMessage());
            return exceptionHandlingRepeat(supplier, printErrorFunction);
        }
    }
}
