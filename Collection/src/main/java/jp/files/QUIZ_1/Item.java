package jp.files.QUIZ_1;

public class Item {

    private String name;
    private int rank;
    private Type type;
    private double durability;
    private String description;
    enum Type {CLOTH,LEATHER,PLATE};

    public Item(String name, int rank,Type type,double durability,String description){
        this.name = name;
        this.rank = rank;
        this.type = type;
        this.durability = durability;
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public void setName(String names){
        this.name = names;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Type getItemType() {
        return type;
    }

    public void setItemType(Type itemType) {
        this.type = itemType;
    }

    public double getDurability() {
        return durability;
    }

    public void setDurability(double durability) {
        this.durability = durability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String toStringg(){
        String cadena = ("Item Name: " + name + " Item type: " +  type + "Item description : "+description);
        return cadena;
    }
    
}
