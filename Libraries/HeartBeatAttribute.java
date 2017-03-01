package HeartRateProgram.Libraries;

/**
 * Created by ruhana on 2/18/17.
 */
public class HeartBeatAttribute {
    private int rr;
    private int baseLine;
    private int rrChange;


    HeartBeatAttribute(int rr) {
        this.rr = rr;
        this.baseLine = -1;
        this.rrChange = -1;
    }
    HeartBeatAttribute() {
        this.rr = -1;
        this.baseLine = -1;
        this.rrChange = -1;
    }


    public int getRr() {
        return rr;
    }

    public void setRr(int rr) {
        this.rr = rr;
    }

    public int getBaseLine() {
        return baseLine;
    }

    public void setBaseLine(int baseLine) {
        this.baseLine = baseLine;
    }

    public int getRrChange() {
        return rrChange;
    }

    public void setRrChange(int rrChange) {
        this.rrChange = rrChange;
    }
}
