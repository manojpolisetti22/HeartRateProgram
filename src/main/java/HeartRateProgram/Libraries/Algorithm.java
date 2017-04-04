//package HeartRateProgram.HBAT.src.HeartRateProgram.Libraries;
package HeartRateProgram.Libraries;

import java.util.*;

/**
 * Created by @ruhana on 2/28/17.
 */
public class Algorithm {

    public static void main(String [] args) {
        MainParser mp = new MainParser();

        String rfilename = "/Users/ruhana/IdeaProjects/HeartRateDeceleration/src/HeartRateProgram/docs/dataSamples/Sample_RR.csv";
        String afilename = "/Users/ruhana/IdeaProjects/HeartRateDeceleration/src/HeartRateProgram/docs/dataSamples" +
                "/Sample_Behavior.csv";
        //List of RR's
        List<Double> rrList = mp.csvParserHeartRate(rfilename);


        //List of Attributes
        List<Attribute> attributeList = mp.csvParserBehavioral(afilename);


        HashMap<Double, Attribute> finalMap = mp.finalParser(rrList, attributeList, 21.7, 67, 23);


        Algorithm al = new Algorithm();
        Trial trail = new Trial("1000" ,"ChildA", new Date(2017,2,28), new Date(2017,2,28), Sex.FEMALE);
        trail.setAttributeTable(finalMap);
        //al.printTable(trail.getAttributeTable());
        trail.setAttributeTable(al.calculate(finalMap));
        //al.printTable(trail.getAttributeTable());


       trail.setAttributeTable(al.calculatePhases(trail.getAttributeTable()));

        al.printTable(trail.getAttributeTable());






       /*LinkedList<Double> timestamps = new LinkedList();
        Trial trail = new Trial("1000" ,"ChildA", new Date(2017,2,28), new Date(2017,2,28), Sex.FEMALE);
        HashMap<Double, Attribute> table = new HashMap<>();




        double currStamp = (double) 71000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START , CODE_TYPE.TASK));
        currStamp = (double) 71680;
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
        currStamp = (double) 75657;
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
        table.put(currStamp, new Attribute(currStamp, 409));
        currStamp = (double) 75897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 408));
        currStamp = (double) 75303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 76657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 390));
        currStamp = (double) 76680;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76093;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 313));
        currStamp = (double) 76493 ;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 309));
        currStamp = (double) 76897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 308));
        currStamp = (double) 76303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 307));
        currStamp = (double) 77500;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));

        currStamp = (double) 78013;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 453));
        currStamp = (double) 78167;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 410));
        currStamp = (double) 78500;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.LOOK));
        currStamp = (double) 78657;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 490));
        currStamp = (double) 78700;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));


        Algorithm s = new Algorithm();
        trail.setAttributeTable(table);
        s.printTable(trail.getAttributeTable());
        


        table = s.calculate( trail.getAttributeTable());
        s.printTable(trail.getAttributeTable());
        table = s.calculatePhases(table);
        s.printTable(table);
        System.out.println("HELLO!!asdf!"); */

    }
    // CORNER CASES:
    // what do you do when the

    public HashMap<Double, Attribute> calculate( HashMap<Double, Attribute> attributeTable) {
        List<Double> timeList = sortKeys(attributeTable);
        Collections.sort(timeList);

        double [] lastFive = clearLastFive(new double[5]); // last five rr's
        double baseLine = -1; // baseline since last look
        int looking = 0; // 0 = not looking; 1 == looking
        int task = 0;
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
                    if (checkForQuickLook(i, attributeTable, timeList) == 1) {
                        looking = 1;
                    } else {
                        looking = 0;
                        baseLine = -1;
                    }
                    lastFive = clearLastFive(lastFive);
                    prevBaseLine = baseLine;

                }

                if (looking == 1 && hR.getRr() != -1 ) { // sets baseline whenever looking and rr is avaliable  //
                    // ADD TASK == 1 HERE
                    hR.setBaseLine(baseLine);
                    hR.setRrChange(Math.abs(hR.getBaseLine() - hR.getRr()));
                }

                if (bH.getCode_type() == CODE_TYPE.TASK && bH.getEvent_type() == EVENT_TYPE.START) {
                    task = 1;
                } else if (bH.getCode_type() == CODE_TYPE.TASK && bH.getEvent_type() == EVENT_TYPE.STOP) {
                    task = 0;
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

    public void printTable( HashMap<Double, Attribute> table) {
        List<Double> timestamps = sortKeys(table);
        System.out.print("**************************************************************************************************************************************************************************\n");
        for(int i = 0; i < timestamps.size(); i ++) {
            Double key = timestamps.get(i);
            Attribute attribute = table.get(key);
            BehaviorAttribute bH = attribute.getbH();
            HeartBeatAttribute hR = attribute.gethR();

            System.out.format("Timestamp: %s\t\trr: %s\t\tCodeType: %s\t\tEventType: %s\t\tBase: %s\t\trrChange: " +
                    "%s\tPhases: %s\n", Double.toString(key), Double.toString(hR.getRr()), bH.getCode_type(), bH.getEvent_type(), Double.toString(hR.getBaseLine()), Double.toString(hR.getRrChange()), Integer.toString(hR.getPhase()));
        }
        System.out.print("**************************************************************************************************************************************************************************\n");

    }

    public HashMap<Double, Attribute> calculatePhases( HashMap<Double, Attribute> attributeTable) {
        List<Double> timeList = sortKeys(attributeTable);
        Collections.sort(timeList);

        int look = 0;
        int task = 1;
        int currPhase = -2; // equates to "."
        double [] lastFive = clearLastFive(new double[5]);
        for(int i = 0; i < timeList.size(); i ++) {
            double time = timeList.get(i);

            if (attributeTable.containsKey(time) && attributeTable.get(time) != null) {
                Attribute attribute = attributeTable.get(time);
                BehaviorAttribute bH = attribute.getbH();
                HeartBeatAttribute hR = attribute.gethR();

                if(bH.getCode_type() == CODE_TYPE.LOOK && bH.getEvent_type() == EVENT_TYPE.START) {
                    look = 1;
                } else if (bH.getCode_type() == CODE_TYPE.LOOK && bH.getEvent_type() == EVENT_TYPE.STOP) {
                    // loop through the next five to see if the look starts again
                    // if it does then don't count this as the end of the look
                    int check = checkForQuickLook(i, attributeTable, timeList);
                    if (check != 1) { // WILL ONLY ACCOUNT THE LOOK IF ITS NOT A QUICK LOOK
                        look = 0;
                        lastFive = clearLastFive(lastFive);
                    }
                } else if (bH.getCode_type() == CODE_TYPE.TASK && bH.getEvent_type() == EVENT_TYPE.START) {
                    task = 1;
                } else if (bH.getCode_type() == CODE_TYPE.LOOK && bH.getEvent_type() == EVENT_TYPE.START) {
                    task = 0;
                    lastFive = clearLastFive(lastFive);
                }

                if (task == 0) { // FOR PHASE '.'
                    currPhase = -2;
                    attribute.gethR().setPhase(currPhase);
                } else if (task == 1 && look == 0) { // FOR PHASE 0
                    currPhase = 0;
                    attribute.gethR().setPhase(currPhase);
                } else if(attribute.gethR().getRr() != -1) { // FOR PHASES 1-3



                    int isLess = isLastFiveLess(attribute.gethR().getBaseLine(), lastFive);
                    int isGreat = isLastFiveGreater(attribute.gethR().getBaseLine(), lastFive);
                    if (isLess == -1 || isGreat == -1) {
                        currPhase = 1;
                    } else if (isLess == 1 && currPhase == 2) { // OR isGreat == 1 if its the other way
                        currPhase = 3;
                    } else if (isGreat == 1) {
                        currPhase = 2;
                    }
                    attribute.gethR().setPhase(currPhase);
                    lastFive = addNewElement(lastFive, attribute.gethR().getRr());
                }

            }

        }
        return attributeTable;
    }

    int isLastFiveLess(double baseLine, double [] lastfive) {
        for(int i = 0; i < lastfive.length; i++) {
            if (lastfive[i] == -1) {
                return -1; //insufficient data
            } else if (lastfive[i] >= baseLine) {
                return 0;
            }
        }
        return  1;
    }

    int isLastFiveGreater(double baseLine, double [] lastfive) {
        for(int i = 0; i < lastfive.length; i++) {
            if (lastfive[i] == -1) {
                return -1; //insufficient data
            } else if (lastfive[i] < baseLine) {
                return 0;
            }
        }
        return  1;
    }

    int checkForQuickLook(int index, HashMap<Double, Attribute> attributeTable, List<Double> timeList) {
        if (timeList.size() < index + 5) return 0;
        for(int i = 0; i < 5; i++) {
            double time = timeList.get(i + index);
            Attribute attribute = attributeTable.get(time);
            if (attribute == null) {
              return 0;
            }
            BehaviorAttribute bH = attribute.getbH();
            if (bH.getCode_type() == CODE_TYPE.LOOK && bH.getEvent_type() == EVENT_TYPE.START) {
                return 1;
            }
        }
        return 0;
    }




    public List<Double> sortKeys(HashMap<Double, Attribute> finalMap) {

        List<Double> unsortedKeys = new ArrayList<Double>(finalMap.keySet());

        Collections.sort(unsortedKeys);

        //Collections.reverse(unsortedKeys);

        return unsortedKeys;
    }


}
