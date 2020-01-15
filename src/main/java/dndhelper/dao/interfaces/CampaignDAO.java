package dndhelper.dao.interfaces;

import java.util.List;

import dndhelper.entity.Character;
import dndhelper.entity.Location;
import dndhelper.entity.Npc;
import dndhelper.entity.Campaign;

public interface CampaignDAO {

    public List<Campaign> getCampaigns();
    public Campaign getCampaignById(int id);
    public void saveCampaign(Campaign campaign);
    public void deleteCampaign(int id);
    public List<Location> getLocations(Campaign campaign);
    public List<Npc> getNpcs(Campaign campaign);
}
