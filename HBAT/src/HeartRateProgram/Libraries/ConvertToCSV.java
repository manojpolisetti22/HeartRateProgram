//package HeartRateProgram.HBAT.src.HeartRateProgram.Libraries;
package HeartRateProgram.Libraries;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
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
    private static final String FILE_HEADER = "Timestamp, rr, CodeType, EventType, Base, rrChange ";
    private static final String UNKNOWN = ".";

    public static void convertToCSV(String fileName, HashMap<Double,Attribute> table) {
    Algorithm algo = new Algorithm();
    List<Double> timestamps = algo.sortKeys(table);   
     FileWriter fw = null;
     BufferedWriter bw = null;   
        
        try { // MAYBE USE HANDLER INSTEAD!
            fw = new FileWriter(fileName);
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
                    bw.write (bH.getCode_type().toString());
                    bw.write(COMMA_DELIMITER);
                    bw.write( bH.getEvent_type().toString() );
                    bw.write(COMMA_DELIMITER);
                    if (hR.getBaseLine() == -1) {
                         bw.write(UNKNOWN);
                    } else {
                        bw.write(Double.toString(hR.getBaseLine()) );
                    }
                    bw.write(COMMA_DELIMITER);
                    if (hR.getRrChange() == -1) {
                        bw.write(UNKNOWN);
                    } else {
                        bw.write(Double.toString(hR.getRrChange()) );
                    }
                    bw.write(COMMA_DELIMITER);
                    bw.write(NEW_LINE);  
                } 
            }
            
            bw.close();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
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

        convertToCSV("/Users/ruhana/IdeaProjects/HeartRateDeceleration/src/HeartRateProgram/testCSV" , trail);

    }
}
