package dndhelper.service.interfaces;

import java.util.List;

import dndhelper.entity.Monster;

public interface MonsterService {

    public List<Monster> getMonsters();
    public Monster getMonsterByName(String name);
    public void saveMonster(Monster monster);
    public void deleteMonster(String name);
}
