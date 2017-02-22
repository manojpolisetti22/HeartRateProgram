package HeartRateProgram;
import java.util.Date;

/**
 * Created by ruhana on 2/16/17.
 */

public class Trail {
    private String trailID; // ID to THIS trail
    private Child child; // 'Child' object specific child
    private Date trailDate; // time when the trail was taken

    Trail (String trailID, Child child, Date trailDate) { // Creates a new trail for a old Child
        this.trailID = trailID;
        this.child = child;
        this.trailDate = trailDate;
    }

    Trail (String trailID, String childID, Date trailDate, Date birthDate, Sex sex) { // Creates a new trail and new
    // Child
        this.trailID = trailID;
        this.trailDate = trailDate;
        this.child = new Child(childID, birthDate, sex);
    }

    public void setTrailID (String trailID) {
        this.trailID = trailID;
    }

    public String getTrailID() {
        return this.trailID;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public Child getChild() {
        return child;
    }

    public void setTrailDate(Date trailDate) {
        this.trailDate = trailDate;
    }

    public Date getTrailDate() {
        return trailDate;
    }

}
