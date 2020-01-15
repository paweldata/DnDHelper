package dndhelper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dndhelper.dao.interfaces.CharacterDAO;
import dndhelper.entity.Character;
import dndhelper.entity.Item;

@Repository
public class CharacterDAOImpl implements CharacterDAO {

    @Autowired
    private SessionFactory sessionFactory;
    
    public List<Character> getCharacters() {
        // TODO Auto-generated method stub
        return null;
    }

    public Character getCharacterById(int id) {
    	Session session = sessionFactory.getCurrentSession();
    	Character character = session.get(Character.class, id);
        return character;
    }

    public void saveCharacter(Character character) {
    	Session session = sessionFactory.getCurrentSession();
    	session.saveOrUpdate(character);
    }

    public void deleteCharacter(int id) {
    	Session session = sessionFactory.getCurrentSession();
    	Character character = session.get(Character.class, id);
    	character.getPlayer().getCharacters().remove(character);
    	List <Item> items = character.getItems();
    	if(!items.isEmpty()) {
    		for(Item tempItem : items) {
    			tempItem.getCharacters().remove(character);
    		}
    	}
    	session.delete(character);
    }

}
