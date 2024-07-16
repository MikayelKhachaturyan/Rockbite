package core;

import java.util.ArrayList;
import java.util.List;

public class PatternScaler {
    private static final char[] patternChars = {'b', 's'};

    private final List<Double> binary;
    private final int length;

    public PatternScaler(String pattern) {
        binary = new ArrayList<>();

        for(int i = 0; i<pattern.length(); i++) {
            if(pattern.charAt(i) == patternChars[0]) {
                binary.add(0.0);
            }
            else {
                binary.add(1.0);
            }
        }

        length = binary.size();
    }

    public String scale(int n, Function interpolatingFunction) {
        StringBuilder builder = new StringBuilder();

        interpolatingFunction.setData(zeroOnePartition(length), binary);

        for(Double value : zeroOnePartition(n)) {
            Double interpolation = interpolatingFunction.at(value);
            builder.append(interpolation > 0.5 ? patternChars[1] : patternChars[0]);
        }

        return builder.toString();
    }

    private List<Double> zeroOnePartition(int length) {
        List<Double> result = new ArrayList<>();
        for(int i = 0; i < length; i++) {
            result.add( (double) i / length);
        }

        return result;
    }

}
