package jp.sgttp.model.domain;

public class Luggage {
    
    static int luggageId = 0;
    float weight;
    int wagonId;
    public Luggage(){
        sumarId();
        this.weight = -1;
        this.wagonId = -1;
    }
    private void sumarId(){
        this.luggageId ++;
    }
    public Luggage(float weight, int wagonId){
        sumarId();
        this.weight = weight;
        this.wagonId = wagonId;
    }

    public int getLuggageId() {
        return luggageId;
    }
    public int getWagonId() {
        return wagonId;
    }
    public float getWeight() {
        return weight;
    }
    public void setLuggageId(int luggageId) {
        this.luggageId = luggageId;
    }
    public void setWagonId(int wagonId) {
        this.wagonId = wagonId;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    }
    public static Luggage getNullLuggage(){
        return new Luggage();
    }
}
