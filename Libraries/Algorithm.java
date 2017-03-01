package HeartRateProgram.Libraries;

import sun.awt.image.ImageWatched;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by ruhana on 2/28/17.
 */
public class Algorithm {




    public static void main() {
        LinkedList<Integer> timestamps = new LinkedList();
        Trial trail = new Trial("1000" ,"ChildA", new Date(2017,2,28), new Date(2017,2,28), Sex.FEMALE);
        Algorithm s = new Algorithm();
        s.calculateBase(timestamps, trail.getAttrubuteTable() );

    }

    public int calculateBase( LinkedList<Integer> timeList, HashMap attributeTable) {
        int [] lastFive = new int [5];
        int baseLine = -1; // baseline since last look
        int looking = 0; // 0 = not looking; 1 == looking

        for (int i = 0; i < timeList.size(); i++) {
            int time = timeList.get(i);

            if (attributeTable.containsKey(time) && attributeTable.get(time) != null) { // CHECKS TO SEE THE KEY EXISTS
                Attribute attribute = attributeTable.get(time);
                Attribute att = attributeTable.get()

                if ( attribute.gethR() != null) { // add to the queue of last five
                    lastFive = addNewElement(lastFive, attribute.gethR().getRr());
                }
                if (attribute.getbH() != null) { // checks if behavioral attribute exists // THESE NEED TO BE FIXED
                    BehaviorAttribute bH = attribute.getbH();

                    if (bH.getCode_type() == CODE_TYPE.LOOK && bH.getEvent_type() == EVENT_TYPE.START) {
                        baseLine = getMedian(lastFive);
                        looking = 1;
                    } else if (bH.getCode_type() == CODE_TYPE.LOOK && bH.getEvent_type() == EVENT_TYPE.STOP) {
                        looking = 0;
                    }
                }

                if (looking == 1) { // sets baseline whenever looking
                    attribute.getbH().setBaseLine(baseLine);
                }
            }
        }
        return 0;
    }

     int [] addNewElement( int [] lastFive, int newElement ) {
        int [] newArr = new int[5];
         for (int i = 0 ; i < lastFive.length; i++) {
            if (i == lastFive.length) {
                continue;
            } else {
                newArr[i + 1] = lastFive[i];
            }
        }
        newArr[0] = newElement;
         return newArr;
    }

    int getMedian (int [] lastFive) {
        Arrays.sort(lastFive);
        return lastFive[3];
    }

}
