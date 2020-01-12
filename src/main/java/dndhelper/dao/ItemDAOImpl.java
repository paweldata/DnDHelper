package dndhelper.dao;

import java.util.List;

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
        // TODO Auto-generated method stub
        return null;
    }

    public Item getItemByName(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    public void saveItem(Item item) {
        // TODO Auto-generated method stub

    }

    public void deleteItem(String name) {
        // TODO Auto-generated method stub

    }

}
