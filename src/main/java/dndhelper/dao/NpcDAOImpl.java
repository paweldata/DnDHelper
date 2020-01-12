package dndhelper.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dndhelper.dao.interfaces.NpcDAO;
import dndhelper.entity.Npc;

@Repository
public class NpcDAOImpl implements NpcDAO {
    
    @Autowired
    private SessionFactory sessionFactory;

    public List<Npc> getNpcs() {
        // TODO Auto-generated method stub
        return null;
    }

    public Npc getNpcById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    public void saveNpc(Npc npc) {
        // TODO Auto-generated method stub

    }

    public void deleteNpc(int id) {
        // TODO Auto-generated method stub

    }

}
