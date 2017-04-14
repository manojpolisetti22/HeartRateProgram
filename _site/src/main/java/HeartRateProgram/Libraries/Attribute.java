//package HeartRateProgram.HBAT.src.HeartRateProgram.Libraries;
package HeartRateProgram.Libraries;

/*import hbat_gui.BehaviorAttribute;
import hbat_gui.CODE_TYPE;
import hbat_gui.EVENT_TYPE;
import hbat_gui.HeartBeatAttribute;
import java.util.LinkedList;*/


/**
 * Created by @ruhana on 2/18/17.
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

    public Attribute(double timestamp, EVENT_TYPE event_type, CODE_TYPE code_type, int event_num) {
        this.timestamp = timestamp;
        this.hR = new HeartBeatAttribute();
        this.bH = new BehaviorAttribute(event_type, code_type, event_num);
    }

    public Attribute(double timestamp, double rr) {
        this.timestamp = timestamp;
        this.hR = new HeartBeatAttribute(rr);
        this.bH = new BehaviorAttribute();
    }

    public Attribute(double timestamp, EVENT_TYPE event_type, CODE_TYPE code_type) {
        this.timestamp = timestamp;
        this.bH = new BehaviorAttribute(event_type, code_type);
        this.hR = new HeartBeatAttribute();
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

    public EVENT_TYPE getEvent_type() {
        return bH.getEvent_type();
    }

    public int getEvent_num() {
        return bH.getEvent_num();
    }

    public CODE_TYPE getCode_type() {
        return bH.getCode_type();
    }

    public double getRr() {
        return hR.getRr();
    }


    public double getBaseLine() {
        return hR.getBaseLine();
    }


    public double getRrChange() {
        return hR.getRrChange();
    }

    public int getPhase() {
        return hR.getPhase();
    }
}
