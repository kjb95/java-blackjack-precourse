package domain.user;

import domain.card.Deck;
import dto.PlayerCardDto;
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
}
