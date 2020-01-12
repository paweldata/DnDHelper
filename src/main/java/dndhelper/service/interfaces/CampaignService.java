package dndhelper.service.interfaces;

import java.util.List;

import dndhelper.entity.Campaign;

public interface CampaignService {

    public List<Campaign> getCampaigns();
    public Campaign getCampaignById(int id);
    public void saveCampaign(Campaign campaign);
    public void deleteCampaign(int id);
}
