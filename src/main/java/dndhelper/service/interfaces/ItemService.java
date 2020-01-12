package dndhelper.service.interfaces;

import java.util.List;

import dndhelper.entity.Item;

public interface ItemService {
    
    public List<Item> getItems();
    public Item getItemByName(String name);
    public void saveItem(Item item);
    public void deleteItem(String name);
}
