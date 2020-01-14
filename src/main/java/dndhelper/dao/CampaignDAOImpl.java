package dndhelper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dndhelper.dao.interfaces.CampaignDAO;
import dndhelper.entity.Campaign;

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

}
