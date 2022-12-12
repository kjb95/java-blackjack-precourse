package domain.user;

import constant.ErrorMessage;
import domain.card.Deck;
import dto.PlayerCardDto;
import dto.PlayerCardResultDto;
import dto.RevenueDto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerGroup {

    private final List<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void initCardDistribution(Deck deck) {
        players.forEach(player -> initCardDistribution(deck, player));
    }

    public void initCardDistribution(Deck deck, Player player) {
        player.addCard(deck.draw());
        player.addCard(deck.draw());
    }

    public List<PlayerCardDto> createPlayerCardDtos() {
        return players.stream()
                .map(Player::createPlayerCardDto)
                .collect(Collectors.toList());
    }


    public Player findPlayerByName(String playerName) {
        return players.stream()
                .filter(player -> player.isSameName(playerName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_EXIST_PLAYER));
    }

    public List<PlayerCardResultDto> createPlayerCardResultDtos() {
        return players.stream()
                .map(Player::createPlayerCardResultDto)
                .collect(Collectors.toList());
    }

    public List<RevenueDto> computeRevenue(User dealer) {
        return players.stream()
                .map(player -> player.computeRevenue(dealer))
                .collect(Collectors.toList());
    }
}
