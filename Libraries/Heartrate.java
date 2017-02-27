package HeartRateProgram.Libraries;

import java.util.LinkedList;

/**
 * Created by ruhana on 2/18/17.
 */
public class Heartrate {

    LinkedList<DataPoint> h_dataList;

    Heartrate() {
        h_dataList = new LinkedList<>();
    }

    public LinkedList<DataPoint> getB_dataList() {
        return h_dataList;
    }

    public void setB_dataList(LinkedList<DataPoint> b_dataList) {
        this.h_dataList = b_dataList;
    }

}
