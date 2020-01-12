package dndhelper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dndhelper.dao.interfaces.CampaignDAO;
import dndhelper.entity.Campaign;
import dndhelper.service.interfaces.CampaignService;

@Service
public class CampaignServiceImpl implements CampaignService {
    
    @Autowired
    private CampaignDAO campaignDAO;
    
    @Transactional
    public List<Campaign> getCampaigns() {
        return this.campaignDAO.getCampaigns();
    }

    @Transactional
    public Campaign getCampaignById(int id) {
       return this.campaignDAO.getCampaignById(id);
    }

    @Transactional
    public void saveCampaign(Campaign campaign) {
        this.campaignDAO.saveCampaign(campaign);
    }

    @Transactional
    public void deleteCampaign(int id) {
        this.campaignDAO.deleteCampaign(id);
    }

}
