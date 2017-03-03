//package HeartRateProgram.HBAT.src.HeartRateProgram.Libraries;
package HeartRateProgram.Libraries;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by @manojpolisetti on 2/22/17.
 */

public class Trial {
    private String trialID; // ID to THIS trail
    private Child child; // 'Child' object specific child
    private Date trialDate; // time when the trail was taken
    private HashMap<Double, Attribute> attributeTable; // timestamp is the Key

//    private Heartrate heartrate;

    public Trial (String trialID, Child child, Date trialDate) { // Creates a new trail for a old Child
        this.trialID = trialID;
        this.child = child;
        this.trialDate = trialDate;
    }

    public Trial (String trialID, String childID, Date trialDate, Date birthDate, Sex sex) { // Creates a new trail and
    // new
        // Child
        this.trialID = trialID;
        this.trialDate = trialDate;
        this.child = new Child(childID, birthDate, sex);
    }

    public void setTrialID (String trailID) {
        this.trialID = trailID;

    }

    public String getTrialID() {
        return this.trialID;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public Child getChild() {
        return child;
    }

    public void setTrialDate(Date trailDate) {
        this.trialDate = trailDate;
    }

    public Date getTrialDate() {
        return trialDate;
    }

    public HashMap<Double, Attribute> getAttributeTable() {
        return attributeTable;
    }

    public void setAttributeTable(HashMap<Double, Attribute> attrubuteTable) {
        this.attributeTable = attrubuteTable;
    }
}
