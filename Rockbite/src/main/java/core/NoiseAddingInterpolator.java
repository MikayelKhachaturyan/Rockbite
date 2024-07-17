package core;

import static java.lang.Math.sin;

public class NoiseAddingInterpolator implements Interpolator {
    private final Interpolator basicInterpolator;

    public NoiseAddingInterpolator(Interpolator basicInterpolator) {
        this.basicInterpolator = basicInterpolator;
    }

    public Double interpolate(Double x, Double f, Double c, Double ff, Double fc) {
        Double interpolation =  basicInterpolator.interpolate(x, f, c, ff, fc);
        interpolation = interpolation * (1 + 0.1 * sin(100 * Math.PI * Math.pow(x, 3)));
        return interpolation;
    }

}
