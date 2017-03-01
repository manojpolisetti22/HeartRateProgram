package HeartRateProgram.Libraries;

/**
 * Created by ruhana on 2/18/17.
 */
public class HeartBeatAttribute {
    private int rr;

    HeartBeatAttribute(int rr) {
        this.rr = rr;
    }
    HeartBeatAttribute() {
        this.rr = -1;
    }


    public int getRr() {
        return rr;
    }

    public void setRr(int rr) {
        this.rr = rr;
    }
}
