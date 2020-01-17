package dndhelper.dao.interfaces;

import java.util.List;

import dndhelper.entity.Monster;

public interface MonsterDAO {

    public List<Monster> getMonsters();
    public void saveMonster(Monster monster);
    public void deleteMonster(int id);
	public Monster getMonsterById(int id);
	public List<Monster> getMosterByChallenge(float challenge);
}
