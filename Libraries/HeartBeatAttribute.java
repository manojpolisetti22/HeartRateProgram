package HeartRateProgram.Libraries;

/**
 * Created by ruhana on 2/18/17.
 */
public class HeartBeatAttribute extends HeartRateProgram.Attribute {
    private float bpm;
    private int ibi;

    HeartBeatAttribute(float bpm, int ibi) {
        this.ibi = ibi;
        this.bpm = bpm;
    }

    public float getBpm() {
        return bpm;
    }

    public int getIbi() {
        return ibi;
    }

    public void setBpm(float bpm) {
        this.bpm = bpm;
    }

    public void setIbi(int ibi) {
        this.ibi = ibi;
    }
}
