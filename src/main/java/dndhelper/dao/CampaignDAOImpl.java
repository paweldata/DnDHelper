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
      
      Query deleteQuery = session.createQuery("DELETE FROM campaign WHERE campaign.id LIKE :campaignId");
      deleteQuery.setParameter("campaignId", id);
      deleteQuery.executeUpdate();
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
}
