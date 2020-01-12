package dndhelper.dao.interfaces;

import java.util.List;

import dndhelper.entity.Player;

public interface PlayerDAO {

    public List<Player> getPlayers();
    public Player getPlayerByNick(String nick);
    public void savePlayer(Player player);
    public void deletePlayer(String nick);
}
