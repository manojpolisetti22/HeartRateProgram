package HeartRateProgram.HBAT.src.HeartRateProgram.Libraries;


/*import com.sun.tools.doclint.HtmlTag;*/ //This import was causing issues; is it necessary?
import java.lang.*;
import java.io.*;
import java.nio.Buffer;
import java.util.*;

/**
 * Created by manojpolisetti on 2/22/17.
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
        String fileName = "/Users/manojpolisetti/Desktop/GitHub/HBAT/src/HeartRateProgram/Documents/Tonsen's Samples/Sample_DataGrid.csv";
        MainParser mp = new MainParser();
        mp.csvParserDataGrid(fileName);
//        System.out.println("hello world");
    }

    public void csvParserDataGrid(String fileName) {
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
            for (DataGrid dg:DataGrids
                 ) {

                System.out.println(dg.toString());
            }


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
    }

    public void csvParserBehavioral(String fileName) {
        //takes in the Behavioral CSV file and parses through it

        BufferedReader fileReader = null;
        try {

            String currentLine = "";

            //Array List to store all the timestamps
            List<Double> times = new ArrayList<Double>();

            //HashMap to contain the attribute wiht the timestamp as the key
            HashMap<Double, Attribute> behavioralMap = new HashMap<Double, Attribute>();

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

                    CODE_TYPE codeType = HeartRateProgram.HBAT.src.HeartRateProgram.Libraries.CODE_TYPE.valueOf(code_type);

                    EVENT_TYPE eventType = HeartRateProgram.HBAT.src.HeartRateProgram.Libraries.EVENT_TYPE.valueOf(event_type);

                    // ASSUMING that Trials with Event_Num are not necessary, and hence aren't added
                    // to the hashmap and hence the timestamps arent added to the list either

                    if (event_num != -1) {
                        Attribute currAttribute = new Attribute(Double.parseDouble(fields[0]), eventType, codeType, event_num);
                        behavioralMap.put(Double.parseDouble(fields[0]), currAttribute);

                        //Add the time stamp to the times list
                        times.add(Double.parseDouble(fields[0]));
                    }

                }
            }

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
    }

    public void csvParserHeartRate(String fileName) {
        BufferedReader fileReader = null;
        try {

            String currentLine = "";

            //New list of Trials to be used to store the read CSV data
            List<Double> rr_times = new ArrayList<Double>();

            //New list fo rstoring the cumulative rr timee
            List<Double> rr_cumulative = new ArrayList<Double>();

            //set cumulative counter to 0 for the first time
            double cumulative = 0;

            //Create FileReader
            fileReader = new BufferedReader(new FileReader(fileName));

            while ((currentLine = fileReader.readLine()) != null) {

                double rr = Double.parseDouble(currentLine);

                //Adds the rr to rr_times
                rr_times.add(rr);

                //Adds the cumulative rr at that time to the list
                rr_cumulative.add(rr + cumulative);

                //changes the cumulative counter to the present rr to be added to the next one
                cumulative = rr;
            }

            //Print if necessary


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
    }
}

