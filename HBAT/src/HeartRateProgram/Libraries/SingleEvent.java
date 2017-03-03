package HeartRateProgram.HBAT.src.HeartRateProgram.Libraries;

/**
 * Created by ruhana on 2/22/17.
 */
// THIS CLASS IS NOT CURRENTLY USED. FOR LATER
public class SingleEvent {
    public int eventNumber;
    public String eventName;

    public SingleEvent (int eventNumber, String eventName) {
        this.eventName = eventName;
        this.eventNumber = eventNumber;
    }
    public SingleEvent(int eventNumber) {
        this.eventNumber = eventNumber;
    }

}
