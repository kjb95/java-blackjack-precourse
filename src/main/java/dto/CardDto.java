package dto;

public class CardDto {

    private final String symbol;
    private final String type;

    public CardDto(String symbol, String type) {
        this.symbol = symbol;
        this.type = type;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getType() {
        return type;
    }
}
