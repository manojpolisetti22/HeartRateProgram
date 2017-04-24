//package HeartRateProgram.HBAT.src.HeartRateProgram.Libraries;
package HeartRateProgram.Libraries;

/**
 * Created by @ruhana on 2/18/17.
 */
public class HeartBeatAttribute {
    private double rr;
    private double baseLine;
    private double rrChange;
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

    public double getBaseLine() {
        return baseLine;
    }

    public void setBaseLine(double baseLine) {
        this.baseLine = baseLine;
    }

    public double getRrChange() {
        return rrChange;
    }

    public void setRrChange(double rrChange) {
        this.rrChange = rrChange;
    }
    
    public void setPhase(int phase) {
        this.phase = phase;
    }
    
    public int getPhase() {
       return this.phase;
    }

}
