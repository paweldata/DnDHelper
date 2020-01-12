package dndhelper.service.interfaces;

import java.util.List;

import dndhelper.entity.Character;

public interface CharacterService {

    public List<Character> getCharacters();
    public Character getCharacterById(int id);
    public void saveCharacter(Character character);
    public void deleteCharacter(int id);
}
