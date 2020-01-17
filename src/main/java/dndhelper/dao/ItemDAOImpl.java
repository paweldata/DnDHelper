package dndhelper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dndhelper.dao.interfaces.ItemDAO;
import dndhelper.entity.Item;

@Repository
public class ItemDAOImpl implements ItemDAO {
    
    @Autowired
    private SessionFactory sessionFactory;

    public List<Item> getItems() {
      Session session = this.sessionFactory.getCurrentSession();
      List<Item> itemList = session.createQuery("FROM Item", Item.class).list();
      
      return itemList;
    }

    public Item getItemByName(String name) {
      Session session = this.sessionFactory.getCurrentSession();
      Item item = session.get(Item.class, name);
      
      return item;
    }

    public void saveItem(Item item) {
      Session session = sessionFactory.getCurrentSession();
      session.saveOrUpdate(item);
    }

    public void deleteItem(String name) {
      Session session = sessionFactory.getCurrentSession();
      Item item = session.get(Item.class, name);
      List<dndhelper.entity.Character> characters = item.getCharacters();
      if(!characters.isEmpty()) {
        for(dndhelper.entity.Character character : characters) {
          character.getItems().remove(item);
        }
      }
      session.delete(item);

    }
}
