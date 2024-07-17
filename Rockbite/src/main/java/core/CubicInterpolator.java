package core;

public class CubicInterpolator implements Interpolator {

    @Override
    public Double interpolate(Double x, Double f, Double c, Double ff, Double fc) {
        return interpolateBetweenZeroOne((x - f) / ( c - f ) , ff, fc);
    }

    private Double interpolateBetweenZeroOne(Double x, Double ff, Double fc) {
        return ff * ( 2 * Math.pow(x, 3) - 3 * Math.pow(x, 2) + 1 ) + fc * ( -2 * Math.pow(x, 3) + 3 * Math.pow(x, 2));
    }
}
