package dndhelper.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dndhelper.dao.interfaces.CharacterDAO;
import dndhelper.entity.Character;

@Repository
public class CharacterDAOImpl implements CharacterDAO {

    @Autowired
    private SessionFactory sessionFactory;
    
    public List<Character> getCharacters() {
        // TODO Auto-generated method stub
        return null;
    }

    public Character getCharacterById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    public void saveCharacter(Character character) {
        // TODO Auto-generated method stub

    }

    public void deleteCharacter(int id) {
        // TODO Auto-generated method stub

    }

}
