package HeartRateProgram;
import java.util.Date;

/**
 * Created by manojpolisetti on 2/22/17.
 */

public class Trial {
    private String trialID; // ID to THIS trail
    private Child child; // 'Child' object specific child
    private Date trialDate; // time when the trail was taken
//    private Heartrate heartrate;

    Trial (String trialID, Child child, Date trailDate) { // Creates a new trail for a old Child
        this.trialID = trialID;
        this.child = child;
        this.trialDate = trailDate;
    }

    Trial (String trialID, String childID, Date trailDate, Date birthDate, Sex sex) { // Creates a new trail and new
        // Child
        this.trialID = trialID;
        this.trialDate = trailDate;
        this.child = new Child(childID, birthDate, sex);
    }

    public void setTrailID (String trailID) {
        this.trialID = trailID;

    }

    public String getTrailID() {
        return this.trialID;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public Child getChild() {
        return child;
    }

    public void setTrailDate(Date trailDate) {
        this.trialDate = trailDate;
    }

    public Date getTrailDate() {
        return trialDate;
    }

}
