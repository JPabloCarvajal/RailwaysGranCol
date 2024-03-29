package jp.sgttp.model.domain.trainUtilities;

import jp.linkedlist.singly.LinkedList;
import jp.sgttp.model.domain.Luggage;

public class LuggageWagon extends Wagon{

    private LinkedList<Luggage> luggagesWagon;
    private float wagonWeight;
    private int luggagesAmount;

    public LuggageWagon(LinkedList<Luggage> luggagesWagon, float wagonWeight, int luggagesAmount, int wagonNum) {
        super(wagonNum);
        this.luggagesWagon = luggagesWagon;
        this.wagonWeight = wagonWeight;
        this.luggagesAmount = luggagesAmount;
    }

    public LinkedList<Luggage> getLuggagesWagon() {
        return luggagesWagon;
    }

    public float getWagonWeight() {
        return wagonWeight;
    }

    public int getLuggagesAmount() {
        return luggagesAmount;
    }

    public void setLuggagesWagon(LinkedList<Luggage> luggagesWagon) {
        this.luggagesWagon = luggagesWagon;
    }

    public void setWagonWeight(float wagonWeight) {
        this.wagonWeight = wagonWeight;
    }

    public void setLuggagesAmount(int luggagesAmount) {
        this.luggagesAmount = luggagesAmount;
    }
}

