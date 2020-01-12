package dndhelper.dao.interfaces;

import java.util.List;

import dndhelper.entity.DungeonMaster;

public interface DungeonMasterDAO {

    public List<DungeonMaster> getDungeonMasters();
    public DungeonMaster getDungeonMasterByNick(String nick);
    public void saveDungeonMaster(DungeonMaster dungeonMaster);
    public void deleteDungeonMaster(String nick);
}
