package core;

import java.util.List;
import java.util.Map;

public class LinearInterpolatingFunction extends Function {
    public LinearInterpolatingFunction() {
        super();
    }

    @Override public Double at(Double x) {
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
           return ( (x - c) * ff + (f - x) * fc ) / (f - c);
        }
    }
}
