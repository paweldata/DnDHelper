package dndhelper.dao.interfaces;

import java.util.List;

import dndhelper.entity.Npc;

public interface NpcDAO {

    public List<Npc> getNpcs();
    public Npc getNpcById(int id);
    public void saveNpc(Npc npc);
    public void deleteNpc(int id);
}
