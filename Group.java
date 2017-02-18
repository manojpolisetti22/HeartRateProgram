package HeartRateProgram;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ruhana on 2/18/17.
 */
public class Group {
    LinkedList<Trail> trailList = new LinkedList<>();
    String groupName;

    public Group (String groupName) {
        this.groupName = groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setTrailList(LinkedList<Trail> trailList) {
        this.trailList = trailList;
    }

    public LinkedList<Trail> getTrailList() {
        return trailList;
    }

    public String getGroupName() {
        return groupName;
    }
}
