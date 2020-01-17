package dndhelper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dndhelper.dao.interfaces.CampaignDAO;
import dndhelper.entity.Campaign;
import dndhelper.entity.Character;
import dndhelper.entity.Location;
import dndhelper.entity.Note;
import dndhelper.entity.Npc;

@Repository
public class CampaignDAOImpl implements CampaignDAO {

    @Autowired
    private SessionFactory sessionFactory;
    
    public List<Campaign> getCampaigns() {
      Session session = this.sessionFactory.getCurrentSession();
      List<Campaign> campaignList = session.createQuery("FROM campaign", Campaign.class).list();
      
      return campaignList;
    }

    public Campaign getCampaignById(int id) {
      Session session = this.sessionFactory.getCurrentSession();
      Campaign campaign = session.get(Campaign.class, id);
      
      return campaign;
    }

    public void saveCampaign(Campaign campaign) {
      Session session = this.sessionFactory.getCurrentSession();
      session.saveOrUpdate(campaign);
    }

    public void deleteCampaign(int id) {
      Session session = this.sessionFactory.getCurrentSession();
      Campaign campaign = session.get(Campaign.class, id);
      List<dndhelper.entity.Character> characters = campaign.getCharacters();
  	if(!characters.isEmpty()) {
  		for(dndhelper.entity.Character tempCharacter : characters) {
  			tempCharacter.getCampaigns().remove(campaign);
  		}
  	}
		List<Location> locations = campaign.getLocations();
		List<Npc> npcs = campaign.getNpcs();
		List<Note> notes = campaign.getNotes();
		for(Location tempLocation : locations) {
			tempLocation.setCampaign(null);
			tempLocation.setMonsters(null);;
			session.remove(campaign);
		}
		for(Npc tempNpc : npcs) {
			tempNpc.setCampaign(null);
			session.remove(tempNpc);
		}
		for(Note tempNote : notes) {
			tempNote.setCampaign(null);
			session.remove(tempNote);
		}
		campaign.getDungeonMaster().getCampaigns().remove(campaign);
  		campaign.setDungeonMaster(null);
		session.remove(campaign);
      /*Query deleteQuery = session.createQuery("DELETE FROM campaign WHERE campaign.id LIKE :campaignId");
      deleteQuery.setParameter("campaignId", id);
      deleteQuery.executeUpdate();*/
    }

    public List<Location> getLocations(Campaign campaign) {
      Session session = this.sessionFactory.getCurrentSession();
      
      int campaignId = campaign.getId();
      Query query = session.createQuery("FROM Location WHERE id_campaign LIKE :campaignId");
      query.setParameter("campaignId", campaignId);
      List<Location> locationList = query.list();
      
      return locationList;
    }

    public List<Npc> getNpcs(Campaign campaign) {
      Session session = this.sessionFactory.getCurrentSession();
      
      int campaignId = campaign.getId();
      Query query = session.createQuery("FROM Npc WHERE id_campaign LIKE :campaignId");
      query.setParameter("campaignId", campaignId);
      List<Npc> npcList = query.list();
      
      return npcList;
    }

    @Override
    public List<dndhelper.entity.Character> getCharacters(Campaign campaign1) {
      Session session = this.sessionFactory.getCurrentSession();
      Campaign campaign = (Campaign) session.merge(campaign1);
      List<dndhelper.entity.Character> characters = campaign.getCharacters();
      return characters;
    }

    @Override
    public void addExp(int id, int exp, int maxExp) {
      Session session = this.sessionFactory.getCurrentSession();
      Query query = session.createSQLQuery("CALL addExp(:campaignId, :exp, :maxExp)")
        .setParameter("campaignId", id)
        .setParameter("exp", exp)
        .setParameter("maxExp", maxExp);
      query.executeUpdate();
    }
}

/**
 * + " c.id, c.level, c.exp, c.armorClass, c.hitPoints, "
          + "c.speed, c.name, c.race, c.class, c.allignment, c.background, "
          + "c.strength, c,dexternity, c.conctitution, c,intelligence, c.wisdom, c.charisma "*/
