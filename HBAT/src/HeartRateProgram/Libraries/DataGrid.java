package HeartRateProgram.HBAT.src.HeartRateProgram.Libraries;

/**
 * Created by manojpolisetti on 2/26/17.
 */
public class DataGrid {
    private String ParticipantID = "";
    private String USERVAR_1 = "";
    private String USERVAR_2 = "";
    private String RR_PATH = "";
    private String BEH_PATH = "";
    private double RR_START = 0;
    private double RR_SYNC = 0;
    private double BEH_SYNC = 0;

    public DataGrid(String ParticipantID, String USERVAR_1, String USERVAR_2, String RR_PATH, String BEH_PATH, double RR_START, double RR_SYNC, double BEH_SYNC) {
        this.ParticipantID = ParticipantID;
        this.USERVAR_1 = USERVAR_1;
        this.USERVAR_2 = USERVAR_2;
        this.RR_PATH = RR_PATH;
        this.BEH_PATH = BEH_PATH;
        this.RR_START = RR_START;
        this.RR_SYNC = RR_SYNC;
        this.BEH_SYNC = BEH_SYNC;
    }

    @Override
    public String toString() {
        return "DataGrid [id=" + ParticipantID+ ", UserVar_1=" + USERVAR_1 + ", UserVar_2=" + USERVAR_2+ ", RR_Path=" + RR_PATH+ ", BEH_Path="
                + BEH_PATH + ", RR_Start=" + RR_START + ", RR_Sync=" + RR_SYNC + ", BEH_Sync=" + BEH_SYNC + "]";
    }

    public String getParticipantID() {
        return ParticipantID;
    }

    public void setParticipantID(String participantID) {
        ParticipantID = participantID;
    }

    public String getUSERVAR_1() {
        return USERVAR_1;
    }

    public void setUSERVAR_1(String USERVAR_1) {
        this.USERVAR_1 = USERVAR_1;
    }

    public String getUSERVAR_2() {
        return USERVAR_2;
    }

    public void setUSERVAR_2(String USERVAR_2) {
        this.USERVAR_2 = USERVAR_2;
    }

    public String getRR_PATH() {
        return RR_PATH;
    }

    public void setRR_PATH(String RR_PATH) {
        this.RR_PATH = RR_PATH;
    }

    public String getBEH_PATH() {
        return BEH_PATH;
    }

    public void setBEH_PATH(String BEH_PATH) {
        this.BEH_PATH = BEH_PATH;
    }

    public double getRR_START() {
        return RR_START;
    }

    public void setRR_START(int RR_START) {
        this.RR_START = RR_START;
    }

    public double getRR_SYNC() {
        return RR_SYNC;
    }

    public void setRR_SYNC(int RR_SYNC) {
        this.RR_SYNC = RR_SYNC;
    }

    public double getBEH_SYNC() {
        return BEH_SYNC;
    }

    public void setBEH_SYNC(int BEH_SYNC) {
        this.BEH_SYNC = BEH_SYNC;
    }

}
