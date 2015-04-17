package su.dalv.itis.is.corelation;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        CorrelationClass<Integer> aClass = new CorrelationClass<Integer>("data.csv");
        CorrelationClass<Integer> bClass = new CorrelationClass<Integer>("data2.csv");
        Correlator correlator = new Correlator(aClass,bClass);
        Integer arr[] = {0,0,1,0,1,0,1,0};
        final ArrayList<Integer> integers = new ArrayList<Integer>(Arrays.asList(arr));
        System.out.print(integers);
        System.out.print(" correlate to " + correlator.correlate(integers) + " class.");
    }
}
