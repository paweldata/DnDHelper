package dndhelper.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dndhelper.dao.interfaces.MonsterDAO;
import dndhelper.entity.Monster;

@Repository
public class MonsterDAOImpl implements MonsterDAO {
    
    @Autowired
    private SessionFactory sessionFactory;

    public List<Monster> getMonsters() {
        // TODO Auto-generated method stub
        return null;
    }

    public Monster getMonsterByName(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    public void saveMonster(Monster monster) {
        // TODO Auto-generated method stub

    }

    public void deleteMonster(String name) {
        // TODO Auto-generated method stub

    }

}
