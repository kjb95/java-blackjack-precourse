package dto;

import java.util.List;

public class PlayerCardDto {

    private final String playerName;
    private final List<CardDto> cardDtos;

    public PlayerCardDto(String playerName, List<CardDto> cardsDtos) {
        this.playerName = playerName;
        this.cardDtos = cardsDtos;
    }

    public String getPlayerName() {
        return playerName;
    }

    public List<CardDto> getCardDtos() {
        return cardDtos;
    }
}
