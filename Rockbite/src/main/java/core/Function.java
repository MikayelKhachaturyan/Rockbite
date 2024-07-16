package core;

import java.util.List;
import java.util.TreeMap;

public abstract class Function {
    protected TreeMap<Double, Double> inputToOutput;

    public Function() {
        inputToOutput = new TreeMap<>();
    }

    public void setData(List<Double> input, List<Double> output) {
        for(int i = 0; i < input.size(); i++) {
            inputToOutput.put(input.get(i), output.get(i));
        }
    }

    public abstract Double at(Double x);
}
