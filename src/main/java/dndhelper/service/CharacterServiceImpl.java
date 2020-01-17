package dndhelper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dndhelper.dao.interfaces.CharacterDAO;
import dndhelper.entity.Campaign;
import dndhelper.entity.Character;
import dndhelper.entity.Item;
import dndhelper.service.interfaces.CharacterService;

@Service
public class CharacterServiceImpl implements CharacterService {
    
    @Autowired
    private CharacterDAO characterDAO;

    @Transactional
    public List<Character> getCharacters() {
        return this.characterDAO.getCharacters();
    }

    @Transactional
    public Character getCharacterById(int id) {
        return this.characterDAO.getCharacterById(id);
    }

    @Transactional
    public void saveCharacter(Character character) {
        this.characterDAO.saveCharacter(character);
    }

    @Transactional
    public void deleteCharacter(int id) {
        this.characterDAO.deleteCharacter(id);
    }

    @Transactional
    public List<Campaign> getCampaigns(Character character) {
      List<Campaign> campaigns = character.getCampaigns();
      for (Campaign campaign : campaigns);
      return campaigns;
    }

    @Transactional
    public List<Item> getItems(Character character) {
      List<Item> items = character.getItems();
      for (Item item : items);
      return items;
    }

}
