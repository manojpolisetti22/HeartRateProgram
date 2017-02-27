package HeartRateProgram.Libraries;

import HeartRateProgram.Attribute;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;

/**
 * Created by ruhana on 2/18/17.
 */
public class DataPoint {
    private LinkedList<Attribute> attributesList;
    private int timestamp;

    DataPoint(int timestamp) {
        attributesList = new LinkedList<>();
        this.timestamp = timestamp;
    }

    void addAttribute(Attribute newAttribute) {
        attributesList.add(newAttribute);
        return;
    }
}
