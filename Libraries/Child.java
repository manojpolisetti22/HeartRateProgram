package HeartRateProgram.Libraries;

import HeartRateProgram.Libraries.Sex;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * Created by ruhana on 2/18/17.
 */

public class Child {

    private String childID;
    private HeartRateProgram.Libraries.Sex sex;
    private Date birthDate;


    public Child (String childID, Date birthDate, Sex sex ) {
        this.childID = childID;
        this.sex = sex;
        this.birthDate = birthDate;

    }

    public Child (Date birthDate, Sex sex) {
        this.sex = sex;
        this.birthDate = birthDate;
        // ADD HANDLING IF ID IS NOT ADDED
    }

    public void setChildID (String childID) {
        this.childID = childID;
    }

    public String getChildID () {
        return this.childID;
    }

    public void setBithDate ( Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getBirthDate () {
        return this.birthDate;
    }

    public void setSex (Sex sex) {
        this.sex = sex;
    }

    public Sex getSex() {
        return sex;
    }

}
