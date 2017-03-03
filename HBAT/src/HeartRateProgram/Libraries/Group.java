//package HeartRateProgram.HBAT.src.HeartRateProgram.Libraries;
package HeartRateProgram.Libraries;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by @ruhana on 2/18/17.
 */
public class Group {
    HashMap<String, Trial> trialMap = new HashMap<>();
//    LinkedList<Trial> trialList = new LinkedList<>();
    String groupName;

    public Group (String groupName) {
        this.groupName = groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setTrailList(HashMap<String, Trial> trailmap) {
        this.trialMap = trialMap;
    }

    public HashMap<String, Trial> getTrailList() {
        return trialMap;
    }

    public String getGroupName() {
        return groupName;
    }

    public boolean addTrial(Trial trial) {

        if (trialMap.containsKey(trial)) { // If the Trial ID already exists then return false
            return false;
        }
        trialMap.put(trial.getTrialID(), trial);
        return true;
    }
}
