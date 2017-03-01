package HeartRateProgram.Libraries;

import java.util.LinkedList;


/**
 * Created by ruhana on 2/18/17.
 */
public class Attribute {


    private BehaviorAttribute bH;
    private HeartBeatAttribute hR;
    private double timestamp;

    public Attribute(double timestamp) {
        this.timestamp = timestamp;
        this.bH = new BehaviorAttribute();
        this.hR = new HeartBeatAttribute();
    }

    public Attribute(double timestamp, EVENT_TYPE event_type, CODE_TYPE code_type) {
        this.timestamp = timestamp;
        this.bH = new BehaviorAttribute(event_type, code_type);
        this.hR = new HeartBeatAttribute();
    }

    Attribute(double timestamp, int rr) {
        this.timestamp = timestamp;
        this.hR = new HeartBeatAttribute(rr);
        this.bH = new BehaviorAttribute();
    }


    public BehaviorAttribute getbH() {
        return bH;
    }

    public HeartBeatAttribute gethR() {
        return hR;
    }

    public double getTimestamp() {
        return timestamp;
    }

    public void setbH(BehaviorAttribute bH) {
        this.bH = bH;
    }

    public void sethR(HeartBeatAttribute hR) {
        this.hR = hR;
    }

    public void setTimestamp(double timestamp) {
        this.timestamp = timestamp;
    }
}
