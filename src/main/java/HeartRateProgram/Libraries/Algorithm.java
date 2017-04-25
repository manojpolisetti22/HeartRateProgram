//package HeartRateProgram.HBAT.src.HeartRateProgram.Libraries;
package HeartRateProgram.Libraries;

import java.io.IOException;
import java.util.*;

/**
 * Created by @ruhana on 2/28/17.
 */
public class Algorithm {

    public static void main(String [] args)  {
        MainParser mp = new MainParser();

        /*String rfilename = "/Users/ruhana/IdeaProjects/HeartRateDeceleration/src/HeartRateProgram/docs/dataSamples" +
                "/Sample_RR.csv";
        String afilename = "/Users/ruhana/IdeaProjects/HeartRateDeceleration/src/HeartRateProgram/docs/dataSamples" +
                "/Sample_Behavior.csv";
        //List of RR's */

        String extension = "4149";
        String rfilename = "docs/dataSamples" +
                "/Newest Samples/RR_spreadsheets/" + extension + "_RR.csv";
        String afilename = "docs/dataSamples" +
                "/Newest Samples/BD_spreadsheets/"+ extension + "_BD.csv";
        //List of RR's
        List<Double> rrList = mp.csvParserHeartRate(rfilename);


        //List of Attributes
        List<Attribute> attributeList = mp.csvParserBehavioral(afilename);


        HashMap<Double, Attribute> finalMap = mp.finalParser(rrList, attributeList, .771, 0, 0);


        Algorithm al = new Algorithm();
        Trial trail = new Trial("1000" ,"ChildA", new Date(2017,2,28), new Date(2017,2,28), Sex.FEMALE);
        trail.setAttributeTable(finalMap);
        //al.printTable(trail.getAttributeTable());
        try {
            //trail.setAttributeTable(al.calculate(finalMap));
            al.calculateAll(trail);
            al.printTable(trail.getAttributeTable());
        } catch (DoubleStop doubleStop) {
            doubleStop.printStackTrace();
        } catch (DoubleStart doubleStart) {
            doubleStart.printStackTrace();
        }
        //al.printTable(trail.getAttributeTable());


       trail.setAttributeTable(al.calculatePhases(trail.getAttributeTable()));

        al.printTable(trail.getAttributeTable());
        try {
            ConvertToCSV.convertToCSV("docs/dataSamples" +
                    "/Newest Samples/OutFiles/" + extension + ".csv", trail.getAttributeTable());
            TrailStat [] arr = new TrailStat[1];
            arr[0] = trail.getStats();
            ConvertToCSV.convertStatToCSV("docs/dataSamples" +
                    "/Newest Samples/OutFiles/" + extension + "STAT.csv", arr);
        } catch (IOException e) {
            e.printStackTrace();
        }

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

    public double durationTask(HashMap<Double, Attribute> attributeTable) {
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

                if (bH.getCode_type() == CODE_TYPE.TASK && bH.getEvent_type() == EVENT_TYPE.START) {
                    look = time;
                } else if (bH.getCode_type() == CODE_TYPE.TASK && bH.getEvent_type() == EVENT_TYPE.STOP) {
                    totalLook = totalLook + (time - look);
                    look = -1;
                    break;
                }
            }
        }
        if(look != -1 && time != -1) {
            totalLook = totalLook + (time - look);
        }
        return totalLook;
    }

    public double durationPhase(HashMap<Double, Attribute> attributeTable, int phase) {
        if(phase < 0 || phase > 3) {
            return -1; // not a valid phase
        }

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

                if(hR.getPhase() == phase && phaseStart == -1) { // START
                // phase is 0 and it is not previously 0
                    phaseStart = time;
                } else if (phaseStart != -1 && hR.getPhase() != phase) { //STOP
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

    public double averageRrChange(HashMap<Double, Attribute> attributeTable, int phase) {
        if(phase < 1 || phase > 3) {
            return -1; // not a valid phase
        }

        List<Double> timeList = sortKeys(attributeTable);
        Collections.sort(timeList);
        int count = 0;
        double sum = 0;

        for(int i = 0; i < timeList.size(); i ++) {
            double time = timeList.get(i);
            if (attributeTable.containsKey(time) && attributeTable.get(time) != null) {
                Attribute attribute = attributeTable.get(time);
                BehaviorAttribute bH = attribute.getbH();
                HeartBeatAttribute hR = attribute.gethR();

                if(hR.getPhase() == phase && bH.getCode_type() == CODE_TYPE.NA) {
                    sum = sum + hR.getRrChange();
                    count++;
                }
            }
        }

        return sum/(double)count;

    }

    public int phaseNum(HashMap<Double, Attribute> attributeTable, int phase) {
        if(phase < 0 || phase > 3) {
            return -1; // not a valid phase
        }

        List<Double> timeList = sortKeys(attributeTable);
        Collections.sort(timeList);
        double phaseStart = -1;
        int totalPhase = 0;
        double time = -1;

        for(int i = 0; i < timeList.size(); i ++) {
            time = timeList.get(i);
            if (attributeTable.containsKey(time) && attributeTable.get(time) != null) {
                Attribute attribute = attributeTable.get(time);
                BehaviorAttribute bH = attribute.getbH();
                HeartBeatAttribute hR = attribute.gethR();

                if(hR.getPhase() == phase && phaseStart == -1) { // START
                    // phase is 0 and it is not previously 0
                    phaseStart = time;
                } else if (phaseStart != -1 && hR.getPhase() != phase) { //STOP
                    // phase is not 0 and has be 0
                    totalPhase++;
                    phaseStart = -1;
                }

            }
        }

        if (phaseStart != -1 && time != -1) { // was started but not ended
            totalPhase++;
    }

        return totalPhase;
    }

    public double peakLook(HashMap<Double, Attribute> attributeTable) {
        List<Double> timeList = sortKeys(attributeTable);
        Collections.sort(timeList);
        double look = -1;
        double time = -1;
        double maxLook = 0;


        for(int i = 0; i < timeList.size(); i ++) {
            time = timeList.get(i);
            if (attributeTable.containsKey(time) && attributeTable.get(time) != null) {
                Attribute attribute = attributeTable.get(time);
                BehaviorAttribute bH = attribute.getbH();
                HeartBeatAttribute hR = attribute.gethR();

                if (bH.getCode_type() == CODE_TYPE.LOOK && bH.getEvent_type() == EVENT_TYPE.START) {
                    look = time;
                } else if (bH.getCode_type() == CODE_TYPE.LOOK && bH.getEvent_type() == EVENT_TYPE.STOP) {
                    double length = time - look;
                    look = -1;
                    if(length > maxLook) { maxLook = length;}
                }
            }
        }
        if(look != -1 && time != -1) {
            double length = time - look;
            if(length > maxLook) { maxLook = length;}
        }
        return maxLook;
    }

    public double peakPhase(HashMap<Double, Attribute> attributeTable, int phase) {
        if(phase < 0 || phase > 3) {
            return -1; // not a valid phase
        }

        List<Double> timeList = sortKeys(attributeTable);
        Collections.sort(timeList);
        double phaseStart = -1;
        double time = -1;
        double totalPhase = 0;

        double peakLookStart = peakLookStart(attributeTable);
        if(peakLookStart == -1 ) {return totalPhase;}
        int start = timeList.indexOf(peakLookStart);
        if(start == -1 ) {return totalPhase;}

        for(int i = start; i < timeList.size(); i ++) {
            time = timeList.get(i);
            if (attributeTable.containsKey(time) && attributeTable.get(time) != null) {
                Attribute attribute = attributeTable.get(time);
                BehaviorAttribute bH = attribute.getbH();
                HeartBeatAttribute hR = attribute.gethR();
                if (bH.getCode_type() == CODE_TYPE.LOOK && bH.getEvent_type() == EVENT_TYPE.STOP) {
                    totalPhase = totalPhase + (time - phaseStart);
                    return totalPhase;
                }

                if(hR.getPhase() == phase && phaseStart == -1) { // START
                    // phase is 0 and it is not previously 0
                    phaseStart = time;
                } else if (phaseStart != -1 && hR.getPhase() != phase) { //STOP
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

    public double peakLookStart(HashMap<Double, Attribute> attributeTable) {
        List<Double> timeList = sortKeys(attributeTable);
        Collections.sort(timeList);
        double look = -1;
        double time = -1;
        double maxLook = 0;
        double start = -1;


        for(int i = 0; i < timeList.size(); i ++) {
            time = timeList.get(i);
            if (attributeTable.containsKey(time) && attributeTable.get(time) != null) {
                Attribute attribute = attributeTable.get(time);
                BehaviorAttribute bH = attribute.getbH();
                HeartBeatAttribute hR = attribute.gethR();

                if (bH.getCode_type() == CODE_TYPE.LOOK && bH.getEvent_type() == EVENT_TYPE.START) {
                    look = time;
                } else if (bH.getCode_type() == CODE_TYPE.LOOK && bH.getEvent_type() == EVENT_TYPE.STOP) {
                    double length = time - look;

                    if(length > maxLook) {
                        maxLook = length;
                        start = look;
                    }
                    look = -1;
                }
            }
        }
        if(look != -1 && time != -1) {
            double length = time - look;
            if(length > maxLook) {
                start = look;
            }
        }
        return start;
    }

    public double proportionTotal(HashMap<Double, Attribute> attributeTable, int phase) {
        if(phase > 3 || phase < 1) {
            return -1;
        }
        double durationTask = durationTask(attributeTable);
        double durationPhase = durationPhase(attributeTable, phase);
        return durationPhase/durationTask;
    }

    public double proportionPeakLook(HashMap<Double, Attribute> attributeTable, int phase) {
        if(phase > 3 || phase < 1) {
            return -1;
        }
        double durationPeakLook = peakLook(attributeTable);
        double durationPeakPhase = peakPhase(attributeTable, phase);
        return durationPeakPhase/durationPeakLook;
    }



    public HashMap<Double, Attribute> calculateAll(Trial trial) throws DoubleStart, DoubleStop { // returns 0 for error 1
        HashMap<Double, Attribute> attributeTable = trial.getAttributeTable();
        if(attributeTable == null) {return attributeTable;}

        attributeTable = calculate(attributeTable);
        attributeTable = calculatePhases(attributeTable);
        trial.setAttributeTable(attributeTable); // sets the calculated attribute table
        printTable(attributeTable);

        TrailStat s = new TrailStat();

        s.setDurationTask(durationTask(attributeTable)); // duration task
        s.setDurationLook(durationLooking(attributeTable)); // duration look
        s.setDurationOne(durationPhase(attributeTable, 0)); // duration phase 1
        s.setDurationOne(durationPhase(attributeTable, 1)); // duration phase 1
        s.setDurationTwo(durationPhase(attributeTable, 2)); // duration phase 2
        s.setDurationThree(durationPhase(attributeTable, 3)); // duration phase 3
        s.setProportionOne(proportionTotal(attributeTable, 0)); // proportion_0
        s.setProportionOne(proportionTotal(attributeTable, 1)); // proportion_1
        s.setProportionTwo(proportionTotal(attributeTable, 2)); // proportion_2
        s.setProportionThree(proportionTotal(attributeTable, 3)); // proportion_3
        s.setRrChangeOne(averageRrChange(attributeTable, 1)); // rr_change_1
        s.setRrChangeTwo(averageRrChange(attributeTable, 2)); // rr_change_2
        s.setRrChangeThree(averageRrChange(attributeTable, 3)); // rr_change_3
        s.setPhaseNOne(phaseNum(attributeTable, 0)); // phase_n_0
        s.setPhaseNOne(phaseNum(attributeTable, 1)); // phase_n_1
        s.setPhaseNTwo(phaseNum(attributeTable, 2)); // phase_n_2
        s.setPhaseNThree(phaseNum(attributeTable, 3)); // phase_n_3
        s.setPeakDurationTotal(peakLook(attributeTable)); //peak_duration_total
        s.setPeakDurationOne(peakPhase(attributeTable, 1)); // peak_duration_1
        s.setPeakDurationTwo(peakPhase(attributeTable, 2)); // peak_duration_2
        s.setPeakDurationThree(peakPhase(attributeTable, 3)); // peak_duration_3
        s.setPeakLookOne(proportionPeakLook(attributeTable, 1)); // peak_proportion_1
        s.setPeakDurationTwo(proportionPeakLook(attributeTable, 2)); // peak_proportion_2
        s.setPeakLookThree(proportionPeakLook(attributeTable, 3)); // peak_proportion_3
        trial.setStats(s);

        return attributeTable;
    }

}
