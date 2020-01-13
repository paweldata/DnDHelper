package dndhelper.service.interfaces;

import java.util.List;

import dndhelper.entity.DungeonMaster;

public interface DungeonMasterService {

    public List<DungeonMaster> getDungeonMasters();
    public DungeonMaster getDungeonMasterByNick(String nick);
    public void saveDungeonMaster(DungeonMaster dungeonMaster);
    public void deleteDungeonMaster(String nick);
    public boolean loginValidate(DungeonMaster dungeonMaster);
}
