package HeartRateProgram;
import java.util.Date;

/**
 * Created by ruhana on 2/16/17.
 */

public class Trail {
    private String trailID;
    private Child childID;
    private Date trailDate;

    Trail (String trailID, Child childID, Date trailDate) {
        this.trailID = trailID; // ID to THIS trail
        this.childID = childID; // ID to the specific child
        this.trailDate = trailDate;  // when the trail was taken
    }

}
