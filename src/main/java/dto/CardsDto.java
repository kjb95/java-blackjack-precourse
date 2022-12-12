package dto;

import java.util.List;

public class CardsDto {

    private final String playerName;
    private final List<CardsDto> cardsDtos;

    public CardsDto(String playerName, List<CardsDto> cardsDtos) {
        this.playerName = playerName;
        this.cardsDtos = cardsDtos;
    }

    public String getPlayerName() {
        return playerName;
    }

    public List<CardsDto> getCardsDtos() {
        return cardsDtos;
    }
}
