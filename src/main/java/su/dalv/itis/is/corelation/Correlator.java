package su.dalv.itis.is.corelation;


import java.util.ArrayList;
import java.util.Map;

/**
 * Correlate two {@link su.dalv.itis.is.corelation.CorrelationClass}
 *
 * @param <T>
 */
public class Correlator<T extends Number> {

    public enum Class {A, B}

    private double aClassProb;
    private double bClassProb;

    private CorrelationClass<T> aClass;
    private CorrelationClass<T> bClass;

    public Correlator(CorrelationClass aClass, CorrelationClass bClass) {
        this.aClass = aClass;
        this.bClass = bClass;
        int aClassSize = aClass.getLearningData().size();
        int bClassSize = bClass.getLearningData().size();
        int totalSize = +bClass.getLearningData().size();
        aClassProb = (double) aClassSize / totalSize;
        bClassProb = (double) bClassSize / totalSize;
    }

    /**
     * Correlate data to {@link su.dalv.itis.is.corelation.Correlator.Class}
     *
     * @param line
     * @return
     */
    public Class correlate(ArrayList<Integer> line) {
        final double aClassBelongProbability = belongProbability(aClass.getElementProbability(), line, aClassProb);
        final double bClassBelongProbability = belongProbability(bClass.getElementProbability(), line, bClassProb);
        if (aClassBelongProbability > bClassBelongProbability) {
            return Class.A;
        } else {
            return Class.B;
        }
    }

    /**
     * Count belong probability
     *
     * @param prob
     * @param integers
     * @param totalProb
     * @return
     */
    public double belongProbability(ArrayList<Map<String, Double>> prob, ArrayList<Integer> integers, double totalProb) {
        double total = 1;
        for (int i = 0; i < integers.size(); i++) {
            double exist = prob.get(i).get("EXIST");
            double noteExist = prob.get(i).get("NOT_EXIST");

            total = total * (integers.get(i) * exist + (1 - integers.get(i)) * noteExist);
        }
        return totalProb * total;
    }


}
