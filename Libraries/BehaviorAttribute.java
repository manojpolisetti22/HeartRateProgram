package HeartRateProgram.Libraries;

import HeartRateProgram.Libraries.SingleEvent;

/**
 * Created by ruhana on 2/22/17.
 */
public class BehaviorAttribute  {
    private EVENT_TYPE event_type;
    private int event_num;
    private CODE_TYPE code_type;

    public BehaviorAttribute() {
        this.event_type = EVENT_TYPE.NA;
        this.event_num = -1;
        this.code_type = CODE_TYPE.NA;

    }
    public BehaviorAttribute(EVENT_TYPE event_type, CODE_TYPE code_type) {
        this.code_type = code_type;
        this.event_type = event_type;
        this.event_num = -1;
    }
    public BehaviorAttribute(int event_num, CODE_TYPE code_type) {
        this.code_type = code_type;
        this.event_type = EVENT_TYPE.NA;
        this.event_num = event_num;
    }

    public BehaviorAttribute(EVENT_TYPE event_type, CODE_TYPE code_type, int event_num) {
        this.code_type = code_type;
        this.event_type = event_type;
        this.event_num = event_num;
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


}


