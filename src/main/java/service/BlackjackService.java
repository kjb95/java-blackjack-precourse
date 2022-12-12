package service;

import domain.user.Player;
import domain.user.PlayerGroup;

public class BlackjackService {

    private final PlayerGroup playerGroup = new PlayerGroup();

    public void addPlayer(String playerName, int betAmount) {
        Player player = new Player(playerName, betAmount);
        playerGroup.addPlayer(player);
    }
}
