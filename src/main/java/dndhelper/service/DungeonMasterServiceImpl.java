package dndhelper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dndhelper.dao.interfaces.DungeonMasterDAO;
import dndhelper.entity.DungeonMaster;
import dndhelper.service.interfaces.DungeonMasterService;

@Service
public class DungeonMasterServiceImpl implements DungeonMasterService {
    
    @Autowired
    private DungeonMasterDAO dungeonMasterDAO;

    @Transactional
    public List<DungeonMaster> getDungeonMasters() {
        return this.dungeonMasterDAO.getDungeonMasters();
    }

    @Transactional
    public DungeonMaster getDungeonMasterByNick(String nick) {
        return this.dungeonMasterDAO.getDungeonMasterByNick(nick);
    }

    @Transactional
    public void saveDungeonMaster(DungeonMaster dungeonMaster) {
        this.dungeonMasterDAO.saveDungeonMaster(dungeonMaster);
    }

    @Transactional
    public void deleteDungeonMaster(String nick) {
        this.dungeonMasterDAO.deleteDungeonMaster(nick);
    }

}
