package HeartRateProgram.Libraries;

import HeartRateProgram.Libraries.SingleEvent;

/**
 * Created by ruhana on 2/22/17.
 */
public class BehaviorAttribute  {
    private EVENT_TYPE event_type;
    private int event_num;
    private CODE_TYPE code_type;
    private int baseLine;

    BehaviorAttribute() {
        this.event_type = EVENT_TYPE.NA;
        this.event_num = -1;
        this.code_type = CODE_TYPE.NA;
        this.baseLine = -1;
    }

    public EVENT_TYPE getEvent_type() {
        return event_type;
    }

    public int getEvent_num() {
        return event_num;
    }

    public CODE_TYPE getCode_type() {
        return code_type;
    }

    public void setEvent_type(EVENT_TYPE event_type) {
        this.event_type = event_type;
    }

    public void setEvent_num(int event_num) {
        this.event_num = event_num;
    }

    public void setCode_type(CODE_TYPE code_type) {
        this.code_type = code_type;
    }

    public int getBaseLine() {
        return baseLine;
    }

    public void setBaseLine(int baseLine) {
        this.baseLine = baseLine;
    }
}


