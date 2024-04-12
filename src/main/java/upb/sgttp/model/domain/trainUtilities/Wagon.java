package upb.sgttp.model.domain.trainUtilities;

public class Wagon{

    private String asociatedTrainID;
    private int wagonNum;

    public Wagon(int wagonNum,String asociatedTrainID){
        this.wagonNum = wagonNum;
        this.asociatedTrainID = asociatedTrainID;
    }

    public String getAsociatedTrainID() {
        return asociatedTrainID;
    }
    
    public void setAsociatedTrainID(String asociatedTrainID) {
        this.asociatedTrainID = asociatedTrainID;
    }

    public int getWagonNum() {
        return wagonNum;
    }

    public void setWagonNum(int wagonNum) {
        this.wagonNum = wagonNum;
    }

}


