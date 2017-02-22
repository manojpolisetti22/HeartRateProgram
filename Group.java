package HeartRateProgram;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ruhana on 2/18/17.
 */
public class Group {
    LinkedList<Trial> trialList = new LinkedList<>();
    String groupName;

    public Group (String groupName) {
        this.groupName = groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setTrailList(LinkedList<Trial> trailList) {
        this.trialList = trialList;
    }

    public LinkedList<Trial> getTrailList() {
        return trialList;
    }

    public String getGroupName() {
        return groupName;
    }
}
