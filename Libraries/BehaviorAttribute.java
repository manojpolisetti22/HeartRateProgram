package HeartRateProgram.Libraries;

import HeartRateProgram.Libraries.SingleEvent;

/**
 * Created by ruhana on 2/22/17.
 */
public class BehaviorAttribute  {

    private int looking;
    private SingleEvent event;
    // 0 = not looking
    // 1 = looking

    BehaviorAttribute(int looking, int eventNumber) {
        this.looking = looking;
        event = new SingleEvent(eventNumber);
    }
    BehaviorAttribute(int looking, int eventNumber, String eventName) {
        this.looking = looking;
        event = new SingleEvent(eventNumber, eventName);
    }

    public int getLooking() {
        return looking;
    }

    public SingleEvent getEvent() {
        return event;
    }

    public void setLooking(int looking) {
        this.looking = looking;
    }

    public void setEvent(SingleEvent event) {
        this.event = event;
    }
}


