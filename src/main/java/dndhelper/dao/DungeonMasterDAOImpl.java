package dndhelper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.tools.javac.resources.CompilerProperties.Notes;

import dndhelper.dao.interfaces.DungeonMasterDAO;
import dndhelper.entity.Campaign;
import dndhelper.entity.DungeonMaster;
import dndhelper.entity.Location;
import dndhelper.entity.Note;
import dndhelper.entity.Npc;
import dndhelper.entity.Player;

@Repository
public class DungeonMasterDAOImpl implements DungeonMasterDAO {
    
    @Autowired
    private SessionFactory sessionFactory;

    public List<DungeonMaster> getDungeonMasters() {
        Session session = this.sessionFactory.getCurrentSession();
        List<DungeonMaster> dungeonMasterList = session.createQuery("From DungeonMaster", DungeonMaster.class).list();
        
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
        DungeonMaster dungeonMaster = session.get(DungeonMaster.class, nick);
        List<Campaign> campaigns = dungeonMaster.getCampaigns();
    	if(!campaigns.isEmpty()) {
    		
    		for(Campaign tempCampaign : campaigns) {
    			List<dndhelper.entity.Character> characters = tempCampaign.getCharacters();
    	    	if(!characters.isEmpty()) {
    	    		for(dndhelper.entity.Character tempCharacter : characters) {
    	    			tempCharacter.getCampaigns().remove(tempCampaign);
    	    		}
    	    	}
    			tempCampaign.setDungeonMaster(null);
    			List<Location> locations = tempCampaign.getLocations();
    			List<Npc> npcs = tempCampaign.getNpcs();
    			List<Note> notes = tempCampaign.getNotes();
    			for(Location tempLocation : locations) {
    				tempLocation.setCampaign(null);
    				tempLocation.setMonsters(null);;
        			session.remove(tempCampaign);
        		}
    			for(Npc tempNpc : npcs) {
    				tempNpc.setCampaign(null);
        			session.remove(tempNpc);
        		}
    			for(Note tempNote : notes) {
    				tempNote.setCampaign(null);
        			session.remove(tempNote);
        		}
    			session.remove(tempCampaign);
    		}
    	}
    	dungeonMaster.setCampaigns(null);
    	session.remove(dungeonMaster);
        //Query deleteQuery = session.createQuery("DELETE FROM dungeonMaster WHERE dungeonMaster.nick =:dungeonMasterNick");
        //deleteQuery.setParameter(0, nick);
        //deleteQuery.executeUpdate();
    }
}
