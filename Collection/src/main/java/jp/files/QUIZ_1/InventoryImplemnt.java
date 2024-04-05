package jp.files.QUIZ_1;

import jp.array.Array;
import jp.linkedlist.singly.LinkedList;
import jp.util.list.List;

public class InventoryImplemnt implements InventoryInterface {      

    Array<Item> inventory = new Array<>(6);

    @Override
    public void addBag(int lenght) {
        if (lenght == 6 || lenght == 8 || lenght == 12) {
            inventory.dimension(inventory.size() + lenght);
        }
    }

    @Override
    public boolean addItem(Item item) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.contains(item)) {
                return true;
            } 
            else {
                if (inventory.add(item)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<String> displayItems() {
        LinkedList<String> itemsToDisplay = new LinkedList<>();
        for (int i = 0; i < inventory.size(); i++) {
            itemsToDisplay.addFirst(inventory.get(i).toString());     
        }
        return itemsToDisplay;
    }
    
    @Override
    public boolean exchangeItems(int indexItem1, int indexItem2) {
        try{
            Item item1 = inventory.get(indexItem1);
            Item item2 = inventory.get(indexItem2);
            inventory.set(indexItem1, item2);
            inventory.set(indexItem2, item1);
            return true;
            } catch(Exception e){
                return false;
            }
    }

    @Override
    public List<Item> sortTasksByTRange() {
        LinkedList<Item> itemsToDisplay = new LinkedList<>();
        itemsToDisplay.add(inventory);
        itemsToDisplay.sort(e -> e.getRank());
        return itemsToDisplay;
    }
    
    //ordenar alfabeticamente (bueno tener y saber)
    public List<Item> sortTasksByTName() {
        LinkedList<Item> itemsToDisplay = new LinkedList<>();
        for(int i=0; i<itemsToDisplay.size(); i++){
            Item item1 = itemsToDisplay.get(i);
            Item item2 = itemsToDisplay.get(i + 1);
            //si alfabeticamente el 1 esta primero que el 2:
            if(itemsToDisplay.get(i).getName().compareTo(itemsToDisplay.get(i++).getName())>0){
                    itemsToDisplay.set(item1, item2);
                    itemsToDisplay.set(item2, item1);
            }
        }
        return itemsToDisplay;
    }
        
}
