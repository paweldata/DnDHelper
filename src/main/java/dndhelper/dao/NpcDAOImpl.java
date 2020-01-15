package dndhelper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dndhelper.dao.interfaces.NpcDAO;
import dndhelper.entity.Campaign;
import dndhelper.entity.Location;
import dndhelper.entity.Npc;

@Repository
public class NpcDAOImpl implements NpcDAO {
    
    @Autowired
    private SessionFactory sessionFactory;

    public List<Npc> getNpcs() {
      Session session = this.sessionFactory.getCurrentSession();
      List<Npc> npcList = session.createQuery("FROM Npc", Npc.class).list();
      
      return npcList;
    }

    public Npc getNpcById(int id) {
      Session session = this.sessionFactory.getCurrentSession();
      Npc npc = session.get(Npc.class, id);
      
      return npc;
    }

    public void saveNpc(Npc npc) {
      Session session = this.sessionFactory.getCurrentSession();
      session.saveOrUpdate(npc);
    }

    public void deleteNpc(int id) {
      Session session = this.sessionFactory.getCurrentSession();
      
      Query deleteQuery = session.createQuery("DELETE FROM Npc WHERE npc.id LIKE :npcId");
      deleteQuery.setParameter("npcId", id);
      deleteQuery.executeUpdate();
    }

}
