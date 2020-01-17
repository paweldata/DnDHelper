package dndhelper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dndhelper.dao.interfaces.PlayerDAO;
import dndhelper.entity.Player;
import dndhelper.service.interfaces.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {
    
    @Autowired
    private PlayerDAO playerDAO;

    @Transactional
    public List<Player> getPlayers() {
        return this.playerDAO.getPlayers();
    }

    @Transactional
    public Player getPlayerByNick(String nick) {
        return this.playerDAO.getPlayerByNick(nick);
    }

  //TODO: check empty spaces
    @Transactional
    public void savePlayer(Player player) {
        this.playerDAO.savePlayer(player);
    }

    @Transactional
    public void deletePlayer(String nick) {
        this.playerDAO.deletePlayer(nick);
    }

    public boolean loginValidate(Player player) {
      Player testPlayer = playerDAO.getPlayerByNick(player.getNick());
      player.setPassword(Integer.toString(player.getPassword().hashCode()));
      if(testPlayer != null) {
        return (testPlayer.getNick().equals(player.getNick()) && testPlayer.getPassword().equals(player.getPassword()));
      }
      return false;
    }
}
