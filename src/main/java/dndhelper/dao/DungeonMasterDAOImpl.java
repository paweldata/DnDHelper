package dndhelper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dndhelper.dao.interfaces.DungeonMasterDAO;
import dndhelper.entity.DungeonMaster;

@Repository
public class DungeonMasterDAOImpl implements DungeonMasterDAO {
    
    @Autowired
    private SessionFactory sessionFactory;

    public List<DungeonMaster> getDungeonMasters() {
        Session session = this.sessionFactory.getCurrentSession();
        List<DungeonMaster> dungeonMasterList = session.createQuery("FROM dungeonMaster", DungeonMaster.class).list();
        
        return dungeonMasterList;
    }

    public DungeonMaster getDungeonMasterByNick(String nick) {
        Session session = this.sessionFactory.getCurrentSession();
        DungeonMaster dungeonMaster = session.get(DungeonMaster.class, nick);
        
        return dungeonMaster;
    }

    public void saveDungeonMaster(DungeonMaster dungeonMaster) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(dungeonMaster);
        
    }

    public void deleteDungeonMaster(String nick) {
        Session session = this.sessionFactory.getCurrentSession();
        
        Query deleteQuery = session.createQuery("DELETE FROM dungeonMaster WHERE dungeonMaster.nick =:dungeonMasterNick");
        deleteQuery.setParameter(0, nick);
        deleteQuery.executeUpdate();
    }
}
