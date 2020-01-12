package dndhelper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dndhelper.dao.interfaces.ItemDAO;
import dndhelper.entity.Item;
import dndhelper.service.interfaces.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDAO itemDAO;
    
    @Transactional
    public List<Item> getItems() {
        return this.itemDAO.getItems();
    }

    @Transactional
    public Item getItemByName(String name) {
        return this.itemDAO.getItemByName(name);
    }

    @Transactional
    public void saveItem(Item item) {
        this.itemDAO.saveItem(item);
    }

    @Transactional
    public void deleteItem(String name) {
        this.itemDAO.deleteItem(name);
    }

}
