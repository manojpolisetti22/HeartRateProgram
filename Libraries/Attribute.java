package HeartRateProgram.Libraries;

import java.util.LinkedList;

/**
 * Created by ruhana on 2/18/17.
 */
public class Attribute {
    private LinkedList<Attribute> attributesList;
    private int timestamp;

    Attribute(int timestamp) {
        attributesList = new LinkedList<>();
        this.timestamp = timestamp;
    }

    void addAttribute(Attribute newAttribute) {
        attributesList.add(newAttribute);
        return;
    }
}
