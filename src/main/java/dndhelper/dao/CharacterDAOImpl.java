package dndhelper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dndhelper.dao.interfaces.CharacterDAO;
import dndhelper.entity.Character;

@Repository
public class CharacterDAOImpl implements CharacterDAO {

    @Autowired
    private SessionFactory sessionFactory;
    
    public List<Character> getCharacters() {
      Session session = this.sessionFactory.getCurrentSession();
      List<Character> characterList = session.createQuery("FROM player_character", Character.class).list();
      
      return characterList;
    }

    public Character getCharacterById(int id) {
      Session session = this.sessionFactory.getCurrentSession();
      Character character = session.get(Character.class, id);
      
      return character;
    }

    public void saveCharacter(Character character) {
    	Session session = sessionFactory.getCurrentSession();
    	session.save(character);
    }

    public void deleteCharacter(int id) {
      Session session = this.sessionFactory.getCurrentSession();
      
      Query deleteQuery = session.createQuery(
          "DELETE FROM player_character WHERE character.id LIKE :characterId");
      deleteQuery.setParameter("characterId", id);
      deleteQuery.executeUpdate();
    }

}
