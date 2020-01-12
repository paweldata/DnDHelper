package dndhelper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dndhelper.dao.interfaces.NpcDAO;
import dndhelper.entity.Npc;
import dndhelper.service.interfaces.NpcService;

@Service
public class NpcServiceImpl implements NpcService {

    @Autowired
    private NpcDAO npcDAO;
    
    @Transactional
    public List<Npc> getNpcs() {
        return this.npcDAO.getNpcs();
    }

    @Transactional
    public Npc getNpcById(int id) {
        return this.npcDAO.getNpcById(id);
    }

    @Transactional
    public void saveNpc(Npc npc) {
        this.npcDAO.saveNpc(npc);
    }

    @Transactional
    public void deleteNpc(int id) {
        this.npcDAO.deleteNpc(id);
    }

}
