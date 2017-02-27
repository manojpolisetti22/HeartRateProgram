package HeartRateProgram.Libraries;

import java.util.LinkedList;

/**
 * Created by ruhana on 2/18/17.
 */
public class Behavioral {
    private LinkedList<DataPoint> b_dataList;

    Behavioral() {
        b_dataList = new LinkedList<DataPoint>();
    }

    public LinkedList<DataPoint> getB_dataList() {
        return b_dataList;
    }

    public void setB_dataList(LinkedList<DataPoint> b_dataList) {
        this.b_dataList = b_dataList;
    }


}
