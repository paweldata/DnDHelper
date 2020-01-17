package dndhelper.service.interfaces;

import java.util.List;

import dndhelper.entity.Location;
import dndhelper.entity.Monster;

public interface MonsterService {

    public List<Monster> getMonsters();
    public Monster getMonsterById(int id);
    public void saveMonster(Monster monster);
    public void deleteMonster(int id);
	public List<Location> getLocationsByMonsters(int monsterId);
	public List<Monster> getMosterByChallenge(float challenge);
}
