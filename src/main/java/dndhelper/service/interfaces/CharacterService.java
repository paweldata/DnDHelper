package dndhelper.service.interfaces;

import java.util.List;

import dndhelper.entity.Campaign;
import dndhelper.entity.Character;
import dndhelper.entity.Item;

public interface CharacterService {

    public List<Character> getCharacters();
    public Character getCharacterById(int id);
    public void saveCharacter(Character character);
    public void deleteCharacter(int id);
    public List<Campaign> getCampaigns(Character character);
    public List<Item> getItems(Character character);
}
