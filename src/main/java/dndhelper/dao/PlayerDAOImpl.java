package dndhelper.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dndhelper.dao.interfaces.PlayerDAO;
import dndhelper.entity.Location;
import dndhelper.entity.Monster;
import dndhelper.entity.Player;

@Repository
@Transactional
public class PlayerDAOImpl implements PlayerDAO {

    @Autowired
    private SessionFactory sessionFactory;
    
    public List<Player> getPlayers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Player> playerList = session.createQuery("from Player", Player.class).list();
        
        return playerList;
    }

    public Player getPlayerByNick(String nick) {
        Session session = this.sessionFactory.getCurrentSession();
        Player player = session.get(Player.class, nick);
        
        return player;
    }

    public void savePlayer(Player player) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(player);
    }

    public void deletePlayer(String nick) {
        Session session = this.sessionFactory.getCurrentSession();
    	Player player = session.get(Player.class, nick);
    	List<dndhelper.entity.Character> characters = player.getCharacters();
    	if(!characters.isEmpty()) {
    		for(dndhelper.entity.Character tempCharacter : characters) {
    			//player.getCharacters().remove(tempCharacter);
    			tempCharacter.setCampaigns(null);
    			tempCharacter.setPlayer(null);
    			session.remove(tempCharacter);
    		}
    	}
    	player.setCharacters(null);
    	session.remove(player);
        //Query deleteQuery = session.createQuery("DELETE FROM player WHERE player.nick LIKE :playerNick");
        //deleteQuery.setParameter("playerNick", nick);
        //deleteQuery.executeUpdate();
    }
}
