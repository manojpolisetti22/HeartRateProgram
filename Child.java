package HeartRateProgram;

import java.util.Date;

/**
 * Created by ruhana on 2/18/17.
 */

public class Child {


    private int age;
    private Sex sex;
    private Date birthDate;

    private enum Sex {
        FEMALE,
        MALE,
        OTHER
    }

    Child (int age, Sex sex ) {
        this.age = age;
        this.sex = sex;
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
