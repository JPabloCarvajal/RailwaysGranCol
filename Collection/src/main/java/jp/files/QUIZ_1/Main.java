package jp.files.QUIZ_1;

public class Main {
    public static void main(String[] args) {

     InventoryImplemnt inventoryImpl = new InventoryImplemnt();


     inventoryImpl.addBag(6);
     inventoryImpl.addBag(8);
     inventoryImpl.addBag(12);

     Item item1 = new Item("Armadura", 3, Item.Type.PLATE, 90.5, "Armadura de hierro");
     Item item2 = new Item("Montura", 2, Item.Type.LEATHER, 80.0, "Montura de cuero");
     Item item3 = new Item("Tunica", 4, Item.Type.CLOTH, 95.0, "Tunica de algodon");

     inventoryImpl.addItem(item1);
     inventoryImpl.addItem(item2);
     inventoryImpl.addItem(item3);
}
}
