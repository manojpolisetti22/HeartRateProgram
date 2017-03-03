package HeartRateProgram.Libraries;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by @ruhana on 3/2/17.
 */
public class ConvertToCSV {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE = "\n";
    private static final String FILE_HEADER = "Timestamp, rr, CodeType, EventType, Base, rrChange ";

    public static void convertToCSV(String fileName, Trial trail, LinkedList<Double> timestamps) {
        try { // MAYBE USE HANDLER INSTEAD!
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.append(FILE_HEADER.toString());


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
