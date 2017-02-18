package HeartRateProgram;

import java.util.Date;

/**
 * Created by ruhana on 2/18/17.
 */

public class Child {

    private String childID;
    private int age;
    private Sex sex;
    private Date birthDate;


    public Child (String childID, int age, Sex sex ) {
        this.childID = childID;
        this.age = age;
        this.sex = sex;
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

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }


}
