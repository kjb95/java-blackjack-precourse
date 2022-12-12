package service;

import domain.card.Card;
import domain.card.Deck;
import domain.user.Dealer;
import domain.user.Player;
import domain.user.PlayerGroup;
import dto.CardDto;
import dto.PlayerCardDto;
import java.util.List;

public class BlackjackService {

    private final PlayerGroup playerGroup = new PlayerGroup();
    private final Deck deck = new Deck();
    private final Dealer dealer = new Dealer();

    public void addPlayer(String playerName, int betAmount) {
        Player player = new Player(playerName, betAmount);
        playerGroup.addPlayer(player);
    }

    public CardDto dealerInitCardDistribution() {
        Card card = deck.draw();
        dealer.addCard(card);
        dealer.addCard(deck.draw());
        return new CardDto(card.getSymbolName(), card.getTypeName());
    }

    public List<PlayerCardDto> playersInitCardDistribution() {
        playerGroup.initCardDistribution(deck);
        return playerGroup.createPlayerCardDtos();
    }

    public PlayerCardDto drawCard(String playerName) {
        Player player = playerGroup.findPlayerByName(playerName);
        player.addCard(deck.draw());
        return player.createPlayerCardDto();
    }
}
