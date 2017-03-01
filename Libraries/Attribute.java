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
        //bH = new BehaviorAttribute();
        //hR = new HeartBeatAttribute();
    }

    public Attribute(double timestamp, EVENT_TYPE event_type, CODE_TYPE code_type, int event_num) {
        this.timestamp = timestamp;
        this.bH = new BehaviorAttribute(event_type, code_type, event_num);
    }

    Attribute(double timestamp, int rr) {
        this.timestamp = timestamp;
        this.hR = new HeartBeatAttribute(rr);
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
