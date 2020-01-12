package dndhelper.dao.interfaces;

import java.util.List;

import dndhelper.entity.Monster;

public interface MonsterDAO {

    public List<Monster> getMonsters();
    public Monster getMonsterByName(String name);
    public void saveMonster(Monster monster);
    public void deleteMonster(String name);
}
