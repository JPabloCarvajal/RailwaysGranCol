package jp.sgttp.model.domain;

public class Luggage {
    
    int luggageId;
    float weight;
    int wagonId;

    public Luggage(int luggageId,float weight, int wagonId){
        this.luggageId = luggageId;
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

}
