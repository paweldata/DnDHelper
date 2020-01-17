package dndhelper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dndhelper.dao.interfaces.MonsterDAO;
import dndhelper.entity.Campaign;
import dndhelper.entity.Location;
import dndhelper.entity.Monster;
import dndhelper.service.interfaces.MonsterService;

@Service
public class MonsterServiceImpl implements MonsterService {
    
    @Autowired
    private MonsterDAO monsterDAO;

    @Transactional
    public List<Monster> getMonsters() {
        return this.monsterDAO.getMonsters();
    }

    @Transactional
    public Monster getMonsterById(int id) {
        return this.monsterDAO.getMonsterById(id);
    }

    @Transactional
    public void saveMonster(Monster monster) {
        this.monsterDAO.saveMonster(monster);
    }

    @Transactional
    public void deleteMonster(int id) {
        this.monsterDAO.deleteMonster(id);
    }

  @Transactional
	public List<Location> getLocationsByMonsters(int monsterId) {
		Monster monster = monsterDAO.getMonsterById(monsterId);
		List<Location> locations = monster.getLocations();
	      for (Location location : locations);
	      return locations;
	}

  @Transactional
  public List<Monster> getMosterByChallenge(float challenge) {
    return this.monsterDAO.getMosterByChallenge(challenge);
  }

}
