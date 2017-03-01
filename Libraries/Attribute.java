package HeartRateProgram.Libraries;

import java.util.LinkedList;

/**
 * Created by ruhana on 2/18/17.
 */
public class Attribute {


    private BehaviorAttribute bH;
    private HeartBeatAttribute hR;
    private int timestamp;

    Attribute(int timestamp) {
        this.timestamp = timestamp;
        bH = null;
        hR = null;
    }

    public BehaviorAttribute getbH() {
        return bH;
    }

    public HeartBeatAttribute gethR() {
        return hR;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setbH(BehaviorAttribute bH) {
        this.bH = bH;
    }

    public void sethR(HeartBeatAttribute hR) {
        this.hR = hR;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }
}
