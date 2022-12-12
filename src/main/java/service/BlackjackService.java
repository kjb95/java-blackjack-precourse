package service;

import domain.card.Card;
import domain.card.Deck;
import domain.user.Dealer;
import domain.user.Player;
import domain.user.PlayerGroup;
import dto.CardDto;
import dto.DealerCardResultDto;
import dto.PlayerCardDto;
import dto.PlayerCardResultDto;
import dto.RevenueDto;
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

    public PlayerCardDto playerDrawCard(String playerName) {
        Player player = playerGroup.findPlayerByName(playerName);
        player.addCard(deck.draw());
        return player.createPlayerCardDto();
    }

    public boolean isDealerDrawMoreCard() {
        return dealer.isDrawMoreCard();
    }

    public void dealerDrawCard() {
        dealer.addCard(deck.draw());
    }

    public DealerCardResultDto findDealerCardResult() {
        return dealer.toDto();
    }

    public List<PlayerCardResultDto> findPlayersCardResult() {
        return playerGroup.createPlayerCardResultDtos();
    }

    public List<RevenueDto> computeRevenue() {
        return playerGroup.computeRevenue(dealer);
    }

}
