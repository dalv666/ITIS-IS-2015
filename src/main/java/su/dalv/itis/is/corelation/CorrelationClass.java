package su.dalv.itis.is.corelation;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Represent correlation class
 * @param <T>
 */
public class CorrelationClass<T extends Number> {

    public ArrayList<ArrayList<T>> getLearningData() {
        return learningData;
    }

    public ArrayList<Map<String, Double>> getElementProbability() {
        return elementProbability;
    }

    private ArrayList<ArrayList<T>> learningData;
    private ArrayList<Map<String, Double>> elementProbability;


    public CorrelationClass(String fileName) throws IOException {
        learningData = new ArrayList<ArrayList<T>>();
        elementProbability = new ArrayList<Map<String, Double>>();
        learnFromCsvFile(fileName);
        calculateProbability();
    }

    /**
     * Read data from csv file to {@link java.util.List}
     * @param fileName name of the file
     * @throws IOException if the file not found
     */
    private void learnFromCsvFile(String fileName) throws IOException {
        if (learningData == null) {
            throw new NullPointerException();
        }
        URL url = ClassLoader.getSystemResource(fileName);
        final String encode = URLDecoder.decode(url.getFile(), "UTF-8");
        Reader in = new FileReader(encode);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);

        for (CSVRecord record : records) {
            ArrayList<T> rowData = new ArrayList<T>();
            final String row = record.get(0);
            final String[] strings = row.split(";");
            for (String string : strings) {
                rowData.add((T) Integer.valueOf(string));
            }
            learningData.add(rowData);
        }

    }


    /**
     * Calculate probability to every element of collection
     */
    public void calculateProbability() {
        if (learningData == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < learningData.get(0).size(); i++) {
            int exist = 0;
            int notExist = 0;
            for (int j = 0; j < learningData.size(); j++) {
                final T integer = learningData.get(j).get(i);
                if (integer.equals(0)) {
                    notExist++;
                } else {
                    exist++;
                }
            }
            Map<String, Double> values = new HashMap<String, Double>();
            double existProb = (double) exist / learningData.size();
            double notExistProb = (double) notExist / learningData.size();
            values.put("EXIST", existProb);
            values.put("NOT_EXIST", notExistProb);
            elementProbability.add(values);
        }
    }


}
