package dndhelper.dao.interfaces;

import java.util.List;

import dndhelper.entity.Character;

public interface CharacterDAO {
    
    public List<Character> getCharacters();
    public Character getCharacterById(int id);
    public void saveCharacter(Character character);
    public void deleteCharacter(int id);
}
