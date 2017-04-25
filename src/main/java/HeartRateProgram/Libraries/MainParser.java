package HeartRateProgram.Libraries;


import javax.sound.midi.Soundbank;
import java.lang.*;
import java.io.*;
import java.nio.Buffer;
import java.util.*;

/**
 * Created by @manojpolisetti on 2/22/17.
 */
public class MainParser {

    private static final String DELIMITER = ",";

    //DataGrind File Attributes
    private static final int PARTICIPANTID = 0;
    private static final int USERVAR1 = 1;
    private static final int USERVAR2 = 2;
    private static final int RRPATH = 3;
    private static final int BEHPATH = 4;
    private static final int RRSTART = 5;
    private static final int RRSYNC = 6;
    private static final int BEHSYNC = 7;

    //Behavioral File Attributs
    private static final int TIME = 0;
    private static final int CODE_TYPE = 1;
    private static final int EVENT_TYPE = 2;
    private static final int EVENT_NUM = 3;

    //Heart rate File attributes

    private static final int RR = 0;

    /*Should this be main, or a function name like parse(String[] filepath)*/
    public static void main(String[] args) {
        MainParser mp = new MainParser();

        String rfilename = "docs/dataSamples/Sample_RR.csv";
        String afilename = "docs/dataSamples/Sample_Behavior.csv";
        //List of RR's
        List<Double> rrList = mp.csvParserHeartRate(rfilename);
        
        
        //List of Attributes
        List<Attribute> attributeList = mp.csvParserBehavioral(afilename);
        
        
        HashMap<Double, Attribute> finalMap = mp.finalParser(rrList, attributeList, 21.7, 67,23);
        Algorithm al = new Algorithm();
        }


    public List<DataGrid> csvParserDataGrid(String fileName) {
        BufferedReader fileReader = null;
        try {

            String currentLine = "";

            //New list of Trials to be used to store the read CSV data
            List<DataGrid> DataGrids = new ArrayList<DataGrid>();

            //Create FileReader
            fileReader = new BufferedReader(new FileReader(fileName));

            //Read the header to skip it
            fileReader.readLine();


            while ((currentLine = fileReader.readLine()) != null) {
                String[] fields = currentLine.split(DELIMITER);
                if (fields.length > 0) {
                    //Create a new DataGrid object and fill the fields
                    DataGrid grid = new DataGrid(fields[0], fields[1], fields[2], fields[3], fields[4],
                            Double.parseDouble(fields[5]), Double.parseDouble(fields[6]), Double.parseDouble(fields[7]));

                    //Add the data grid to the ArrayList
                    DataGrids.add(grid);
                }
            }


            //Prints the ArrayList of Data Grids
//            for (DataGrid dg:DataGrids
//                 ) {
//
//                System.out.println(dg.toString());
//            }

            return DataGrids;

        } catch (Exception e) {
            System.out.println("Error in Reading Behavioral File");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Attribute> csvParserBehavioral(String fileName) {
        //takes in the Behavioral CSV file and parses through it

        BufferedReader fileReader = null;
        try {

            String currentLine = "";

            //Array List to store all the Attributes
            List<Attribute> attributeList = new ArrayList<Attribute>();

            //Create FileReader
            fileReader = new BufferedReader(new FileReader(fileName));

            //Read the header to skip it
            fileReader.readLine();

            while ((currentLine = fileReader.readLine()) != null) {
                String[] fields = currentLine.split(DELIMITER);
                if (fields.length > 0) {

                    //fields[0] = Times; [1] = Code_type; [2] = Event_type; [3] = Event_num

                    String code_type = fields[1];
                    if (code_type.equals(".")) {
                        code_type = "NA";
                    }

                    String event_type = fields[2];
                    if (event_type.equals(".")){
                        event_type = "NA";
                    }

                    int event_num = -1;
                    String event_numString = fields[3];
                    if (!event_numString.equals(".")){
                        event_num = Integer.parseInt(event_numString);
                    }
                    

                    code_type = code_type.toUpperCase();
                    event_type = event_type.toUpperCase();
                    
                    CODE_TYPE codeType = HeartRateProgram.Libraries.CODE_TYPE.valueOf(code_type);

                    EVENT_TYPE eventType = HeartRateProgram.Libraries.EVENT_TYPE.valueOf(event_type);

                    // ASSUMING that Trials with Event_Num are not necessary, and hence aren't added
                    // to the hashmap and hence the timestamps arent added to the list either

                    if (codeType == HeartRateProgram.Libraries.CODE_TYPE.LOOK) {
                        Attribute currAttribute = new Attribute(Double.parseDouble(fields[0]) + 0.01, eventType, codeType, event_num);

                        //Add the current attribute to the attributeList
                        attributeList.add(currAttribute);
                    }
                    if (codeType == HeartRateProgram.Libraries.CODE_TYPE.TASK) {
                        Attribute currAttribute = new Attribute(Double.parseDouble(fields[0]), eventType, codeType, event_num);
                        //Add the current attribute to the attributeList
                        attributeList.add(currAttribute);
                    }
                    if (codeType == HeartRateProgram.Libraries.CODE_TYPE.TRIAL) {
                        Attribute currAttribute = new Attribute(Double.parseDouble(fields[0]), eventType, codeType, event_num);
                        //Add the current attribute to the attributeList
                        attributeList.add(currAttribute);
                    }

                }
            }

            Collections.sort(attributeList, new Comparator<Attribute>() {
                @Override
                public int compare(Attribute o1, Attribute o2) {
                    return Double.compare(o1.getTimestamp(), o2.getTimestamp());
                }
            });

            return attributeList;

            //behavioralMap has the keys and values, times has the list of timestamps.

        } catch (Exception e) {
            System.out.println("Error in Reading Behavioral File");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }

        return null;
    }

    public List<Double> csvParserHeartRate(String fileName) {
        BufferedReader fileReader = null;
        try {

            //A list of both the rrTimes and the cumulative times
            String currentLine = "";

            //New list of Trials to be used to store the read CSV data
            List<Double> rr_times = new ArrayList<Double>();

            //Create FileReader
            fileReader = new BufferedReader(new FileReader(fileName));

            while ((currentLine = fileReader.readLine()) != null) {

                double rr = Double.parseDouble(currentLine);

                //Adds the rr to rr_times
                rr_times.add(rr);
            }
            
            //returns the list of RR's
            return rr_times;


        } catch (Exception e) {
            System.out.println("Error in Reading Behavioral File");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }

        return null;
    }

    public List<Double> calculateAbsouluteTime(List<Double> rrTimes, double rr_start, double rr_sync, double beh_sync){

        List<Double> absoluteTime = new ArrayList<Double>();

        //The offset in milliseconds
        double offset  = (beh_sync - rr_sync) * 1000.0;

        //Changing the start time to be in milliseconds
        rr_start = rr_start * 1000.0;

        //Setting the cumulative counter to 0
        double cumulative = 0;
        
        double time = rrTimes.get(0) + offset+rr_start;
        
        absoluteTime.add(0, time);
        
        rrTimes.add(0, time);
       
        //for loop to iterate through the rrTimes and add the absolute time to the list
        for (int i = 1; i < rrTimes.size(); i++) {
            
            double temp = rrTimes.get(i) + absoluteTime.get(i-1);

            absoluteTime.add(i,temp);

        }

        return absoluteTime;
    }

    public List<Integer> findAbsoluteTimeIndex(List<Double> absoluteTime, List<Attribute> attrList) {

        //List of matching Indices
        List<Integer> listIndex = new ArrayList<Integer>();

        //Counter for the Attribute List Index
        int attrListIndex = 0;
//        System.out.println(attrList.get(attrList.size()-1).getTimestamp());
//        System.out.println(attrList.get(attrList.size()-1).getCode_type().toString());
        double time = 0.0;

        double attrTime = 0.0;

        for (int i = 0; i < absoluteTime.size(); i++){

            if (attrListIndex < attrList.size()) {

                time = absoluteTime.get(i);

                attrTime = attrList.get(attrListIndex).getTimestamp() * 1000.0;

                if (time >= attrTime) {
                    listIndex.add(i);
                    attrListIndex++;
                }
            }
            else {
                i = absoluteTime.size();
            }
        }

        return listIndex;
    }

    public HashMap<Double, Attribute> finalParser(List<Double> rrList, List<Attribute> attrList, double rr_start,
                                                  double rr_sync, double beh_sync) {

        //List of the Absolute times
        List<Double> absoluteTime = calculateAbsouluteTime(rrList, rr_start, rr_sync, beh_sync);

        //List of the matching Indices
        List<Integer> absoluteTimeVSAttributeTime = findAbsoluteTimeIndex(absoluteTime, attrList);

        //List of keys to the hashmap in order of insertion
        List<Double> keys = new ArrayList<Double>();

        //A HashMap which stores Attribute as a value and the Absolute timestamps as a key
        HashMap<Double, Attribute> finalMap = new HashMap<Double, Attribute>();

        //Strating index of when the Tasks start
        int startIndex = absoluteTimeVSAttributeTime.get(0);

        //Ending index of the Tasks end
        int endIndex = absoluteTimeVSAttributeTime.get(absoluteTimeVSAttributeTime.size() - 1);

        //Counter for looping through the whole list of Attributes already present
        int attrIndex = 0;

        System.out.println(startIndex);

        int test = startIndex - 5;
        if (test < 0) {
            test = 0;
        }

        //For loop which loops through from the start index to the end index of the AbsoluteTimeVsAttributeTime list
        for (int i = test; i < endIndex; i++ ){


            System.out.println(i);

            //If the attribute already exists at that point of time, put it in the map with the respective rr and time
            if (absoluteTimeVSAttributeTime.contains(i)){

                //Make new attribute and set it to the existing one in attrList
                Attribute attribute = attrList.get(attrIndex);
                if (attribute.getCode_type().toString().equals("TASK")) {
                    System.out.println("Task : " + attribute.getEvent_type().toString());
                }
                //Set the timestamp tp be whatever it is supposed to be
                attribute.setTimestamp(absoluteTime.get(i));

                //Add the timestamp in the keys list
                keys.add(attribute.getTimestamp());

                //Add the attribute and the timestamp to the hashmap
                finalMap.put(absoluteTime.get(i), attribute);

                //increment the attrIndex
                attrIndex++;
            }
            else {
                //if there isnt an attribute already with Beh data, make a new one with just HR data and add it
                Attribute attribute = new Attribute(absoluteTime.get(i), rrList.get(i));

                keys.add(absoluteTime.get(i));

                finalMap.put(absoluteTime.get(i), attribute);
            }
        }

        //return the final hashmap
        return finalMap;
    }

    public HashMap<Double, Attribute> createTrial(int trialNum, HashMap<Double, Attribute> finalMap, double time) {
        Attribute attr = new Attribute(time, HeartRateProgram.Libraries.EVENT_TYPE.NA, HeartRateProgram.Libraries.CODE_TYPE.TRIAL, trialNum);
        finalMap.put(time, attr);
        return finalMap;
    }
}


