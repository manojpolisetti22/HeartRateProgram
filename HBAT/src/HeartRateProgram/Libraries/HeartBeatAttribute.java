//package HeartRateProgram.HBAT.src.HeartRateProgram.Libraries;
package HeartRateProgram.Libraries;

/**
 * Created by @ruhana on 2/18/17.
 */
public class HeartBeatAttribute {
    private double rr;
    private int baseLine;
    private int rrChange;
    private int phase;


    public HeartBeatAttribute(double rr) {
        this.rr = rr;
        this.baseLine = -1;
        this.rrChange = -1;
        this.phase = -1;
    }
    public HeartBeatAttribute() {
        this.rr = -1;
        this.baseLine = -1;
        this.rrChange = -1;
        this.phase = -1;
    }


    public double getRr() {
        return rr;
    }

    public void setRr(double rr) {
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
    
    public void setPhase(int phase) {
        this.phase = phase;
    }
    
    public int getPhase() {
       return this.phase;
    }
}
