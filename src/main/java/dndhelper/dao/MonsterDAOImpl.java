package dndhelper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dndhelper.dao.interfaces.MonsterDAO;
import dndhelper.entity.Character;
import dndhelper.entity.Item;
import dndhelper.entity.Location;
import dndhelper.entity.Monster;
import dndhelper.entity.Player;

@Repository
public class MonsterDAOImpl implements MonsterDAO {
    
    @Autowired
    private SessionFactory sessionFactory;

    public List<Monster> getMonsters() {
    	Session session = this.sessionFactory.getCurrentSession();
        List<Monster> monsterList = session.createQuery("from Monster", Monster.class).list();
        return monsterList;
    }

    public void saveMonster(Monster monster) {
    	Session session = sessionFactory.getCurrentSession();
    	session.saveOrUpdate(monster);
    }

    public void deleteMonster(int id) {
    	Session session = sessionFactory.getCurrentSession();
    	Monster monster = session.get(Monster.class, id);
    	List <Location> locations = monster.getLocations();
    	if(!locations.isEmpty()) {
    		for(Location tempLoc : locations) {
    			tempLoc.getMonsters().remove(monster);
    		}
    	}
    	session.delete(monster);

    }

	@Override
	public Monster getMonsterById(int id) {
		Session session = sessionFactory.getCurrentSession();
    	Monster monster = session.get(Monster.class, id);
        return monster;
	}

}
