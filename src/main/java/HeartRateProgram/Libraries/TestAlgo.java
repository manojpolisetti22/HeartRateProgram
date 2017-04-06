package HeartRateProgram.Libraries;

import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.testng.AssertJUnit.assertFalse;

/**
 * Created by ruhana on 4/4/17.
 */
public class TestAlgo {
    @Test
    public void hello() {
        assertFalse(false);
    }


    @Test
    public void testNormal() {
        LinkedList<Double> timestamps = new LinkedList();
        Trial trail = new Trial("1000" ,"ChildA", new Date(2017,2,28), new Date(2017,2,28), Sex.FEMALE);
        HashMap<Double, Attribute> table = new HashMap<>();




        double currStamp = (double) 71000;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.START, CODE_TYPE.TASK));
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
        currStamp = (double) 78700;
        timestamps.add(currStamp);
        table.put(currStamp, new Attribute(currStamp, EVENT_TYPE.STOP, CODE_TYPE.LOOK));


        Algorithm s = new Algorithm();
        trail.setAttributeTable(table);
        s.printTable(trail.getAttributeTable());



        HashMap<Double, Attribute> output= s.calculate( trail.getAttributeTable());
        s.printTable(output);
        output = s.calculatePhases(output);
        s.printTable(output);


        for(int i = 11; i < 21; i++) {
            double time =  timestamps.get(i);
            double baseline = output.get(time).getBaseLine();
            assertTrue(baseline == 407);
        }
    }

    @Test
    public void quickLook() {
        LinkedList<Double> timestamps = new LinkedList();
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



        HashMap<Double, Attribute> output= s.calculate( trail.getAttributeTable());
        s.printTable(output);
        output = s.calculatePhases(output);
        s.printTable(output);


        for(int i = 11; i < 19; i++) {
            double time =  timestamps.get(i);
            double baseline = output.get(time).getBaseLine();
            assertTrue(baseline == 407);
        }
        double time =  timestamps.get(22);
        double baseline = output.get(time).getBaseLine();
        assertTrue(baseline == 407);

        time =  timestamps.get(23);
        baseline = output.get(time).getBaseLine();
        assertTrue(baseline == 407);

        time =  timestamps.get(25);
        baseline = output.get(time).getBaseLine();
        assertTrue(baseline == 407);
    }


}
