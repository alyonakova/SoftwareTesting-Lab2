public class Sin extends AbstractFunction {

    public Sin(Double eps) {
        super(eps);
    }

    @Override
    public Double getResult(Double x) {
        if (Double.isNaN(x) || Double.isInfinite(x)) {
            return Double.NaN;
        }
        x = correctX(x);
        Double xn = x;
        Double previous = 0.0;
        Double result = x;
        final Double EPS = 1e-10, INF = 1.0e8;
        for (Integer n = 1; Math.abs(Math.abs(result) - Math.abs(previous)) > EPS; n++) {
            previous = result;
            xn *= (-x*x)/((2*n+1)*2*n);
            result += xn;
        }
        return Math.abs(result) > INF ? Double.NaN : result;
    }

    private Double correctX(Double x) {
        double period = Math.PI * 2;
        if (x < 0)
            period *= -1;
        while (Math.abs(x) > 30.0) {
            x -= period;
        }
        return x;
    }
}
