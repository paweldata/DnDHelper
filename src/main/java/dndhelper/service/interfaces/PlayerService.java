package dndhelper.service.interfaces;

import java.util.List;

import dndhelper.entity.Player;

public interface PlayerService {

    public List<Player> getPlayers();
    public Player getPlayerByNick(String nick);
    public void savePlayer(Player player);
    public void deletePlayer(String nick);
    public boolean loginValidate(Player player);
}
