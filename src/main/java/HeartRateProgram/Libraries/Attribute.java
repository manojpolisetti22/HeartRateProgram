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


    public String getStringCode_type() {
        if(bH.getCode_type() == CODE_TYPE.NA) {
            return "";
        }
        return bH.getCode_type().toString();
    }

    public String getStringEvent_type() {
        if(bH.getEvent_type() == EVENT_TYPE.NA) {
            return "";
        }
        return bH.getEvent_type().toString();
    }

    public String getStringRr() {
        if(hR.getRr() == -1) {
            return ".";
        }
        return Double.toString(hR.getRr());
    }

    public String getStringEvent_num() {
        if (bH.getEvent_num() == -1) {
            return "";
        } else {
            return Integer.toString(bH.getEvent_num());
        }
    }

    public String getStringBaseLine() {
        if (hR.getBaseLine() == -1) {
            return ".";
        } else {
           return Double.toString(hR.getBaseLine()) ;
        }
    }

    public String getStringRrChange() {
        if (hR.getBaseLine() == -1) { // checks to see if there is a behavioral data since hR
            // and bH data
            // cannot overlap
            return ".";
        } else {
            return Double.toString(hR.getRrChange()) ;
        }
    }

    public String getStringPhase() {
        if(hR.getPhase() < 0 ) {
            return ".";
        } else {
            return Integer.toString(hR.getPhase());
        }
    }


}
