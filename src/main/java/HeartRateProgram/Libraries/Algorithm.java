//package HeartRateProgram.HBAT.src.HeartRateProgram.Libraries;
package HeartRateProgram.Libraries;

import java.util.*;

/**
 * Created by @ruhana on 2/28/17.
 */
public class Algorithm {

    public static void main(String [] args)  {
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
        try {
            trail.setAttributeTable(al.calculate(finalMap));
        } catch (DoubleStop doubleStop) {
            doubleStop.printStackTrace();
        } catch (DoubleStart doubleStart) {
            doubleStart.printStackTrace();
        }
        //al.printTable(trail.getAttributeTable());


       trail.setAttributeTable(al.calculatePhases(trail.getAttributeTable()));

        al.printTable(trail.getAttributeTable());

        //double ans = al.durationTask(trail.getAttributeTable());
        //System.out.println(ans);


    }
    // CORNER CASES:
    // what do you do when the

    public HashMap<Double, Attribute> calculate( HashMap<Double, Attribute> attributeTable) throws DoubleStop, DoubleStart {
        List<Double> timeList = sortKeys(attributeTable);
        Collections.sort(timeList);

        double [] lastFive = clearLastFive(new double[5]); // last five rr's
        double baseLine = -1; // baseline since last look
        int looking = 0; // 0 = not looking; 1 == looking
        int actualLook = 0;
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
                    if(actualLook == 1) { // ADD THIS
                        String text = "Two Consecutive Looks without any stop found at time " + time + ".\n";
                        throw new DoubleStart(text);
                    }
                    if (getMedian(lastFive) == -1) {
                        baseLine = prevBaseLine;
                        prevBaseLine = -1;
                    } else {
                        baseLine = getMedian(lastFive);
                    }
                    looking = 1;
                    actualLook = 1;
                } else if (bH.getCode_type() == CODE_TYPE.LOOK && bH.getEvent_type() == EVENT_TYPE.STOP) { // stop look
                    // resets everything
                    if (looking == 0) {
                        String text = "Two Consecutive Stops without any Look Start found at time " + time +
                                        "%d\n";
                        throw new DoubleStop(text);
                    }
                    if (checkForQuickLook(i, attributeTable, timeList) == 1) {
                        looking = 1;
                    } else {
                        looking = 0;
                        baseLine = -1;
                    }
                    lastFive = clearLastFive(lastFive);
                    prevBaseLine = baseLine;
                    actualLook = 0;
                }

                if (looking == 1 && hR.getRr() != -1 && task == 1) { // sets baseline whenever looking and rr is
                // avalaible //
                    // ADD TASK == 1 HERE
                    hR.setBaseLine(baseLine);
                    hR.setRrChange(Math.abs(hR.getBaseLine() - hR.getRr()));
                }

                if (bH.getCode_type() == CODE_TYPE.TASK && bH.getEvent_type() == EVENT_TYPE.START) {
                    task = 1;
                } else if (bH.getCode_type() == CODE_TYPE.TASK && bH.getEvent_type() == EVENT_TYPE.STOP) {
                    task = 2;
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
        int task = 0;
        int currPhase = -1; // equates to "."
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
                    currPhase = -1;
                    attribute.gethR().setPhase(currPhase);
                } else if (task == 1 && look == 0) { // FOR PHASE 0
                    currPhase = 0;
                    attribute.gethR().setPhase(currPhase);
                } else if (hR.getBaseLine() == -1) {
                    // does nothing
                } else if (attribute.gethR().getRr() != -1) { // FOR PHASES 1-3



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

    int isLastFiveLess (double baseLine, double [] lastfive) {
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

        List<Double> unsortedKeys = new ArrayList<>(finalMap.keySet());

        Collections.sort(unsortedKeys);

        //Collections.reverse(unsortedKeys);

        return unsortedKeys;
    }

    public double durationLooking(HashMap<Double, Attribute> attributeTable) {
        List<Double> timeList = sortKeys(attributeTable);
        Collections.sort(timeList);
        double look = -1;
        double totalLook = 0;
        double time = -1;

        for(int i = 0; i < timeList.size(); i ++) {
            time = timeList.get(i);
            if (attributeTable.containsKey(time) && attributeTable.get(time) != null) {
                Attribute attribute = attributeTable.get(time);
                BehaviorAttribute bH = attribute.getbH();
                HeartBeatAttribute hR = attribute.gethR();

                if (bH.getCode_type() == CODE_TYPE.LOOK && bH.getEvent_type() == EVENT_TYPE.START) {
                    look = time;
                } else if (bH.getCode_type() == CODE_TYPE.LOOK && bH.getEvent_type() == EVENT_TYPE.STOP) {
                    totalLook = totalLook + (time - look);
                    look = -1;
                }
            }
        }
        if(look != -1 && time != -1) {
            totalLook = totalLook + (time - look);
        }
        return totalLook;
    }

    /*public double durationTask(HashMap<Double, Attribute> attributeTable) {
        List<Double> timeList = sortKeys(attributeTable);
        Collections.sort(timeList);
        double task = -1;
        double totalTask = 0;
        double time = -1;

        for(int i = 0; i < timeList.size(); i ++) {
            time = timeList.get(i);
            if (attributeTable.containsKey(time) && attributeTable.get(time) != null) {
                Attribute attribute = attributeTable.get(time);
                BehaviorAttribute bH = attribute.getbH();
                HeartBeatAttribute hR = attribute.gethR();

                if (bH.getCode_type() == CODE_TYPE.TASK && bH.getEvent_type() == EVENT_TYPE.START) {
                    task = time;
                } else if (bH.getCode_type() == CODE_TYPE.TASK && bH.getEvent_type() == EVENT_TYPE.STOP) {
                    totalTask = totalTask + (time - task);
                    task = -1;
                    break; // only one task is allowed per dataset
                }
            }
        }

        if(task != -1 && time != -1) {
            totalTask = totalTask + (time - task);
        }
        return totalTask;
    } */

    public double durationPhaseZero(HashMap<Double, Attribute> attributeTable) {
        List<Double> timeList = sortKeys(attributeTable);
        Collections.sort(timeList);
        double phaseStart = -1;
        double totalPhase = 0;
        double time = -1;

        for(int i = 0; i < timeList.size(); i ++) {
            time = timeList.get(i);
            if (attributeTable.containsKey(time) && attributeTable.get(time) != null) {
                Attribute attribute = attributeTable.get(time);
                BehaviorAttribute bH = attribute.getbH();
                HeartBeatAttribute hR = attribute.gethR();

                if(hR.getPhase() == 0 && phaseStart == -1) { // START
                // phase is 0 and it is not previously 0
                    phaseStart = time;
                } else if (phaseStart != -1 && hR.getPhase() != 0) { //STOP
                // phase is not 0 and has be 0
                    totalPhase = totalPhase + (time - phaseStart);
                    phaseStart = -1;
                }

            }
        }

        if (phaseStart != -1 && time != -1) { // was started but not ended
            totalPhase = totalPhase + (time - phaseStart);
        }


        return totalPhase;
    }






}
