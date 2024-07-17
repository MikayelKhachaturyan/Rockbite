package core;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Function {
    protected TreeMap<Double, Double> inputToOutput;
    protected Interpolator interpolator;

    public Function(Interpolator interpolator) {
        inputToOutput = new TreeMap<>();
        this.interpolator = interpolator;
    }

    public void setData(List<Double> input, List<Double> output) {
        for(int i = 0; i < input.size(); i++) {
            inputToOutput.put(input.get(i), output.get(i));
        }
    }

    public Double at(Double x) {
        Map.Entry<Double, Double> ceiling = inputToOutput.ceilingEntry(x);
        Map.Entry<Double, Double> floor = inputToOutput.floorEntry(x);

        Double c = (ceiling == null) ? null : ceiling.getKey();
        Double fc = (ceiling == null) ? null: ceiling.getValue();
        Double f = (floor == null) ? null : floor.getKey();
        Double ff = (floor == null) ? null : floor.getValue();

        if(c == null && f == null) {
            return null;
        }
        else if(f == null) {
            return fc;
        }
        else if(c == null) {
            return ff;
        }
        else if(f.equals(c)) {
            return fc;
        }
        else {
               return interpolator != null ? interpolator.interpolate(x, f, c, ff, fc) : null;
        }
    }
}
