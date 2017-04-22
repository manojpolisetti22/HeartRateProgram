//package HeartRateProgram.HBAT.src.HeartRateProgram.Libraries;
package HeartRateProgram.Libraries;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by @ruhana on 3/2/17.
 */
public class ConvertToCSV {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE = "\n";
    private static final String FILE_HEADER = "Timestamp, rr, CodeType, EventType, Event_Num, Base, rrChange, Phase ";
    private static final String STAT_HEADER = "Duration_Task, Duration_Looking, Duration_0, Duration_1, Duration_2, " +
            "Duration_3, Proportion_0, Proportion_1, Proportion_2, Proportion_3, RR_Change_1, RR_Change_2, " +
            "RR_Change_3, Phases_N_0, Phases_N_1, Phases_N_2, Phases_N_3, Peak_Duration_Total, Peak_Duration_1, " +
            "Peak_Duration_2, Peak_Duration_3, Peak_Proportion_1, Peak_Proportion_2, Peak_Proportion_3";
    private static final String UNKNOWN = ".";

    public static File convertToCSV (String fileName, HashMap<Double, Attribute> table) throws IOException {
    Algorithm algo = new Algorithm();
    List<Double> timestamps = algo.sortKeys(table);   
     FileWriter fw;
     BufferedWriter bw;
        File f = null;


            f = new File(fileName);
            fw = new FileWriter(f);
            //fw = new FileWriter(fileName);
            bw = new BufferedWriter(fw);
            bw.write(FILE_HEADER);
            bw.write(NEW_LINE);
            
            
            for(int i = 0; i < timestamps.size(); i++) {
                double time = timestamps.get(i);
                if (table.containsKey(time) && table.get(time) != null) { // checks for error
                    Attribute attribute = table.get(time);
                    BehaviorAttribute bH = attribute.getbH();
                    HeartBeatAttribute hR = attribute.gethR();
                    
                    bw.write(Double.toString(time));
                    bw.write(COMMA_DELIMITER);
                    
                    if (hR.getRr() == -1) {
                        bw.write(UNKNOWN); 
                    }
                    else  {
                        bw.write(Double.toString(hR.getRr())); 
                    }
                    bw.write(COMMA_DELIMITER);
                    if (bH.getCode_type() == CODE_TYPE.NA) {
                        bw.write("");
                    } else {
                        bw.write(bH.getCode_type().toString());
                    }
                    bw.write(COMMA_DELIMITER);
                    if (bH.getEvent_type() == EVENT_TYPE.NA) {
                        bw.write("");
                    } else {
                        bw.write( bH.getEvent_type().toString() );
                    }
                    bw.write(COMMA_DELIMITER); /// THIS IS WHERE U LEFT OFF
                    if (bH.getEvent_num() == -1) {
                        bw.write("");
                    } else {
                        bw.write(Integer.toString(bH.getEvent_num()));
                    }
                    bw.write(COMMA_DELIMITER);
                    if (hR.getBaseLine() == -1) {
                         bw.write(UNKNOWN);
                    } else {
                        bw.write(Double.toString(hR.getBaseLine()) );
                    }
                    bw.write(COMMA_DELIMITER);
                    if (hR.getBaseLine() == -1) { // checks to see if there is a behavioral data since hR
                    // and bH data
                    // cannot overlap
                        bw.write(UNKNOWN);
                    } else {
                        bw.write(Double.toString(hR.getRrChange()) );
                    }
                    bw.write(COMMA_DELIMITER);
                    if(hR.getPhase() < 0 ) {
                        bw.write(UNKNOWN);
                    } else {
                        bw.write(Integer.toString(hR.getPhase()));
                    }
                    bw.write(NEW_LINE);  
                } 
            }
            
            bw.close();
            fw.close();

        return f;
    }

    public static void convertStatToCSV (String fileName, TrailStat stat) throws IOException {
        if(stat == null) {return;}
        Algorithm algo = new Algorithm();
        FileWriter fw;
        BufferedWriter bw;


            fw = new FileWriter(fileName);
            bw = new BufferedWriter(fw);
            bw.write(FILE_HEADER);
            bw.write(NEW_LINE);

            bw.write(Double.toString(stat.getDurationTask()));
            bw.write(COMMA_DELIMITER);
            bw.write(Double.toString(stat.getDurationLook()));
            bw.write(COMMA_DELIMITER);
            bw.write(Double.toString(stat.getDurationZero()));
            bw.write(COMMA_DELIMITER);
            bw.write(Double.toString(stat.getDurationOne()));
            bw.write(COMMA_DELIMITER);
            bw.write(Double.toString(stat.getDurationTwo()));
            bw.write(COMMA_DELIMITER);
            bw.write(Double.toString(stat.getDurationThree()));
            bw.write(COMMA_DELIMITER);


            bw.write(Double.toString(stat.getProportionZero()));
            bw.write(COMMA_DELIMITER);
            bw.write(Double.toString(stat.getProportionOne()));
            bw.write(COMMA_DELIMITER);
            bw.write(Double.toString(stat.getProportionTwo()));
            bw.write(COMMA_DELIMITER);
            bw.write(Double.toString(stat.getProportionThree()));
            bw.write(COMMA_DELIMITER);

            bw.write(Double.toString(stat.getRrChangeOne()));
            bw.write(COMMA_DELIMITER);
            bw.write(Double.toString(stat.getRrChangeTwo()));
            bw.write(COMMA_DELIMITER);
            bw.write(Double.toString(stat.getRrChangeThree()));
            bw.write(COMMA_DELIMITER);

            bw.write(Double.toString(stat.getPhaseNZero()));
            bw.write(COMMA_DELIMITER);
            bw.write(Double.toString(stat.getPhaseNOne()));
            bw.write(COMMA_DELIMITER);
            bw.write(Double.toString(stat.getPhaseNTwo()));
            bw.write(COMMA_DELIMITER);
            bw.write(Double.toString(stat.getPhaseNThree()));
            bw.write(COMMA_DELIMITER);

            bw.write(Double.toString(stat.getPeakDurationTotal()));
            bw.write(COMMA_DELIMITER);
            bw.write(Double.toString(stat.getPeakDurationOne()));
            bw.write(COMMA_DELIMITER);
            bw.write(Double.toString(stat.getPeakDurationTwo()));
            bw.write(COMMA_DELIMITER);
            bw.write(Double.toString(stat.getPeakDurationThree()));
            bw.write(COMMA_DELIMITER);


            bw.write(Double.toString(stat.getPeakLookOne()));
            bw.write(COMMA_DELIMITER);
            bw.write(Double.toString(stat.getPeakLookTwo()));
            bw.write(COMMA_DELIMITER);
            bw.write(Double.toString(stat.getPeakLookThree()));
            bw.write(COMMA_DELIMITER);

            bw.close();
            fw.close();

    }
    
    
    
    
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
        table.put(currStamp, new Attribute(currStamp, 400));
        currStamp = (double) 75897;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 403));
        currStamp = (double) 75303;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, 407));
        currStamp = (double) 75500;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));
 
        trail.setAttributeTable(table);

        try {
            convertToCSV("/Users/ruhana/testCSV" , table);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static int compare (String f1, String f2) {
        try {
            String r1 = readFileAsString(f1);
            String r2 = readFileAsString(f2);

            r1.replace("\n" , ",");
            r2.replace("\n" , ",");

            String [] arr1 = r1.split(",");
            String [] arr2 = r2.split(",");

            if(arr1.length != arr2.length) {
                return 0;
            }
            for(int i = 0; i < arr1.length; i++) {
                if (!arr1[i].equals(arr2[i])) {
                    return 0;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public static String readFileAsString(String filePath) throws IOException {
        StringBuffer fileData = new StringBuffer();
        BufferedReader reader = new BufferedReader(
                new FileReader(filePath));
        char[] buf = new char[1024];
        int numRead=0;
        while((numRead=reader.read(buf)) != -1){
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        reader.close();
        return fileData.toString();
    }
}
