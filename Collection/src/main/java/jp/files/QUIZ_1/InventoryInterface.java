package jp.files.QUIZ_1;

import jp.util.list.List;

public interface InventoryInterface {

    public void addBag(int length);

    public boolean addItem(Item item);

    public List<String> displayItems();
    
    public boolean exchangeItems(int indexItem1,int indexItem2);

    public List<Item> sortTasksByTRange();
}
