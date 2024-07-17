package core;

public class LinearInterpolator implements Interpolator {
    @Override
    public Double interpolate(Double x, Double f, Double c, Double ff, Double fc) {
        return ( (x - c) * ff + (f - x) * fc ) / (f - c);
    }
}
