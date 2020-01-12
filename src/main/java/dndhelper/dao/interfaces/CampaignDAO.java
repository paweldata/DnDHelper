package dndhelper.dao.interfaces;

import java.util.List;

import dndhelper.entity.Campaign;

public interface CampaignDAO {

    public List<Campaign> getCampaigns();
    public Campaign getCampaignById(int id);
    public void saveCampaign(Campaign campaign);
    public void deleteCampaign(int id);
}
