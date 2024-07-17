package core;

import java.util.ArrayList;
import java.util.List;
 /**
 * The <code>PatternScaler</code> class provides functionality to scale a given pattern
 * of the form 'bbssbbb' (containing only the symbols 'b' and 's') to different lengths.
 * <p>
 * The scaling is achieved by representing the pattern as a function defined on the
 * interval [0, 1]. This function maps i/n to either 0 or 1, where i is the
 * position of a character in the pattern, and n is the length of the pattern. In this
 * representation, 'b' is mapped to 0 and 's' is mapped to 1.
 * <p>
 * The function is then used to scale the pattern to a new length N by evaluating the
 * interpolated values of the function at positions i / N. The class allows the use of
 * different interpolation methods to achieve this scaling, also class allows to group
 * the values of a function and do averaging.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 *     Interpolator interpolator = new LinearInterpolator();
 *     PatternScaler scaler = new PatternScaler("bbssss");
 *     System.out.println(scaler.scale(100, interpolator));
 * </pre>
 * </p>
 * @author Mikayel Khachaturyan
 */
public class PatternScaler {
    private static final char[] patternChars = {'b', 's'};

    private final List<Double> numericRepresentation;
    private final int length;

    public PatternScaler(String pattern) {
        this(pattern, 1);
    }

    public PatternScaler(String pattern, int averagingSize) {
        numericRepresentation = new ArrayList<>();

        double sum = 0;
        int n = 0;

        for(int i = 0; i<pattern.length(); i++) {
            if(pattern.charAt(i) == patternChars[0]) {
                sum += 0;
                n++;
            }
            else if (pattern.charAt(i) == patternChars[1]) {
                sum += 1;
                n++;
            }
            if( (i+1) % averagingSize == 0 || i == pattern.length() - 1 ) {
                numericRepresentation.add(sum / n);
                sum = 0;
                n = 0;
            }
        }

        length = numericRepresentation.size();
    }

    public String scale(int n, Interpolator interpolator) {
        StringBuilder builder = new StringBuilder();
        Function function = new Function(interpolator);

        function.setData(zeroOnePartition(length), numericRepresentation);

        for(Double value : zeroOnePartition(n)) {
            Double interpolation = function.at(value);
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
