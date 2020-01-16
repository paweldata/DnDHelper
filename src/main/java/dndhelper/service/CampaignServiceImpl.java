package dndhelper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dndhelper.dao.interfaces.CampaignDAO;
import dndhelper.entity.Campaign;
import dndhelper.entity.Character;
import dndhelper.entity.Location;
import dndhelper.entity.Npc;
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

    @Transactional
    public List<Location> getLocations(Campaign campaign) {
      return this.campaignDAO.getLocations(campaign);
    }

    @Transactional
    public List<Npc> getNpcs(Campaign campaign) {
      return this.campaignDAO.getNpcs(campaign);
    }

    @Transactional
    public List<dndhelper.entity.Character> getCharacters(Campaign campaign) {
      List<dndhelper.entity.Character> characters = campaign.getCharacters();
      for(Character tempCh : characters)
        System.out.println("Characters " + tempCh.getName() + "\n");
      return characters;
    }
}
