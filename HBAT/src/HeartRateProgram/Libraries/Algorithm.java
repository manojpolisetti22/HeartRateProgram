//package HeartRateProgram.HBAT.src.HeartRateProgram.Libraries;
package HeartRateProgram.Libraries;

import java.util.*;

/**
 * Created by @ruhana on 2/28/17.
 */
public class Algorithm {

    public static void main(String [] args) {
        LinkedList<Double> timestamps = new LinkedList();
        Trial trail = new Trial("1000" ,"ChildA", new Date(2017,2,28), new Date(2017,2,28), Sex.FEMALE);
        HashMap<Double, Attribute> table = new HashMap<>();

        double currStamp = (double) 71680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 72493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 400));
        currStamp = (double) 72897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 403));
        currStamp = (double) 73303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 73713;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 453));
        currStamp = (double) 74167;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 410));
        currStamp = (double) 74500;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        /*currStamp = (double) 75657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 490));
        currStamp = (double) 75680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 75093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 413));
        currStamp = (double) 75493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 400));
        currStamp = (double) 75897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 403));*/
        currStamp = (double) 75303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 75500;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));


        Algorithm s = new Algorithm();
        trail.setAttributeTable(table);
        s.printTable(trail.getAttributeTable());

        table = s.calculate( trail.getAttributeTable());
        s.printTable( trail.getAttributeTable());
        
        table = s.calculatePhases(table);
        s.printTable(table);

    }
    // CORNER CASES:
    // what do you do when the

    public HashMap<Double, Attribute> calculate( HashMap<Double, Attribute> attributeTable) {
        List<Double> timeList = sortKeys(attributeTable);
        
        double [] lastFive = clearLastFive(new double[5]); // last five rr's
        double baseLine = -1; // baseline since last look
        int looking = 0; // 0 = not looking; 1 == looking
        double prevBaseLine = -1; // stores the previous baseline // this baseline is used for quick look aways

        for (int i = 0; i < timeList.size(); i++) {
            double time = timeList.get(i);

            if (attributeTable.containsKey(time) && attributeTable.get(time) != null) { // CHECKS TO SEE THE KEY EXISTS
                Attribute attribute = attributeTable.get(time);
                BehaviorAttribute bH = attribute.getbH();
                HeartBeatAttribute hR = attribute.gethR();

                if (attribute.gethR().getRr() != -1) { // add's RR to lastFive if it exists
                    lastFive = addNewElement(lastFive, attribute.gethR().getRr());
                }


                if (bH.getCode_type() == CODE_TYPE.LOOK && bH.getEvent_type() == EVENT_TYPE.START) { // start look
                    if (getMedian(lastFive) == -1) {
                        baseLine = prevBaseLine;
                        prevBaseLine = -1;
                    } else {
                        baseLine = getMedian(lastFive);
                    }
                    looking = 1;
                } else if (bH.getCode_type() == CODE_TYPE.LOOK && bH.getEvent_type() == EVENT_TYPE.STOP) { // stop look
                    // resets everything
                    looking = 0;
                    lastFive = clearLastFive(lastFive);
                    prevBaseLine = baseLine;
                    baseLine = -1;
                }
                
                if (looking == 1 && hR.getRr() != -1) { // sets baseline whenever looking and rr is avaliable 
                    hR.setBaseLine(baseLine);
                    hR.setRrChange(Math.abs(hR.getBaseLine() - hR.getRr()));
                }


            }

        }
        return attributeTable;
    }
    
    

    double [] addNewElement( double [] lastFive, double newElement ) {
        double [] newArr = new double[5];
         for (int i = 0 ; i < lastFive.length; i++) {
            if (i == lastFive.length - 1) {
                continue;
            } else {
                newArr[i + 1] = lastFive[i];
            }
        }
         newArr[0] = newElement;
         return newArr;
    }

    double getMedian (double [] lastFive) {
        for (int i = 0; i < lastFive.length; i++) { // checks that the look was long enough
            if (lastFive[i] == -1) {return  -1;}
        }

        Arrays.sort(lastFive);
        return lastFive[2];
    }

    double [] clearLastFive (double [] lastFive) {
        for (int i = 0; i < lastFive.length; i++) {
            lastFive[i] = -1;
        }
        return lastFive;
    }

    void printTable( HashMap<Double, Attribute> table) {
        List<Double> timestamps = sortKeys(table);
        System.out.print("*************************************************************************************\n");
        for(int i = 0; i < timestamps.size(); i ++) {
            Double key = timestamps.get(i);
            Attribute attribute = table.get(key);
            BehaviorAttribute bH = attribute.getbH();
            HeartBeatAttribute hR = attribute.gethR();
           
            System.out.format("Timestamp: %s\t\trr: %s\t\tCodeType: %s\t\tEventType: %s\t\tBase: %s\t\trrChange: " +
                            "%s\tPhases: %s\n", Double.toString(key), Double.toString(hR.getRr()), bH.getCode_type(), bH.getEvent_type(), Double.toString(hR.getBaseLine()), Double.toString(hR.getRrChange()), Integer.toString(hR.getPhase()));
        }
        System.out.print("*************************************************************************************\n");

    }

 public HashMap<Double, Attribute> calculatePhases( HashMap<Double, Attribute> attributeTable) {
        
    List<Double> timeList = sortKeys(attributeTable);
    int look = 0;
    int currPhase = -1; // equates to "."
    for(int i = 0; i < timeList.size(); i ++) {
        double time = timeList.get(i); 
        double [] lastFive = clearLastFive(new double[5]);
        
        if (attributeTable.containsKey(time) && attributeTable.get(time) != null) {
            Attribute attribute = attributeTable.get(time);
            BehaviorAttribute bH = attribute.getbH();
            HeartBeatAttribute hR = attribute.gethR();
            
            
            hR.setPhase(currPhase);
            if ( bH.getCode_type() == CODE_TYPE.LOOK && bH.getEvent_type() == EVENT_TYPE.STOP) { // stop looking
                look = 0;
                currPhase = 0;
                for(int j = 0; j < 5 ; j++ ){
                    if (bH.getCode_type() == CODE_TYPE.LOOK ) {
                        look = 1;
                        currPhase = currPhase;
                    }
                }
                if (look == 0) {
                    
                } else {
                    look = 1;
                }
                
            } 
            if (look <= 0 && bH.getCode_type() == CODE_TYPE.LOOK && bH.getEvent_type() == EVENT_TYPE.START) {
                look = 1;
                currPhase = 1;
            } else if (bH.getCode_type() == CODE_TYPE.LOOK && bH.getEvent_type() == EVENT_TYPE.START)
            {
                
            } if (currPhase == 1 && hR.getRr() > hR.getBaseLine()) {
                currPhase = 2;
            } else if (currPhase == 2) {
                // first will add to the median and then calculate if it should move to phase 3
                lastFive = addNewElement(lastFive, hR.getRr());
                if (checkPhaseTwo(lastFive, hR.getBaseLine())) {
                    currPhase = 3;
                }
            }

        }
     
    }
    return attributeTable;
    
}

public boolean checkPhaseTwo(double [] lastFive , double baseLine) {
    for(int i = 0; i < lastFive.length; i++) {
        if (lastFive[i] >= baseLine) { // a value was found that is not less than the baseLine
            return false;
        }
    }
    return true; // returns true if all five values sare less than baseline
}   


public List<Double> sortKeys(HashMap<Double, Attribute> finalMap) {
    
    List<Double> unsortedKeys = new ArrayList<Double>(finalMap.keySet());
    
    Collections.sort(unsortedKeys);
    
    Collections.reverse(unsortedKeys);
    
    return unsortedKeys;        
}


}
