package domain.user;

import java.util.ArrayList;
import java.util.List;

public class PlayerGroup {

    private final List<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
    }
}
