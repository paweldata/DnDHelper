package dndhelper.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dndhelper.dao.interfaces.PlayerDAO;
import dndhelper.entity.Player;

@Repository
@Transactional
public class PlayerDAOImpl implements PlayerDAO {

    @Autowired
    private SessionFactory sessionFactory;
    
    public List<Player> getPlayers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Player> playerList = session.createQuery("FROM player", Player.class).list();
        
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
        
        Query deleteQuery = session.createQuery("DELETE FROM player WHERE player.nick LIKE :playerNick");
        deleteQuery.setParameter("playerNick", nick);
        deleteQuery.executeUpdate();
    }
}
