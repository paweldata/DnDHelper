package dndhelper.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dndhelper.dao.interfaces.CampaignDAO;
import dndhelper.entity.Campaign;

@Repository
public class CampaignDAOImpl implements CampaignDAO {

    @Autowired
    private SessionFactory sessionFactory;
    
    public List<Campaign> getCampaigns() {
        // TODO Auto-generated method stub
        return null;
    }

    public Campaign getCampaignById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    public void saveCampaign(Campaign campaign) {
        // TODO Auto-generated method stub

    }

    public void deleteCampaign(int id) {
        // TODO Auto-generated method stub

    }

}
