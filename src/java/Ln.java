public class Ln extends AbstractFunction {

    public Ln(Double eps) {
        super(eps);
    }

    @Override
    public Double getResult(Double x) {
        double result = 0;
        double previous;
        int n = 1;
        int k = 1;
        if (Double.isNaN(x) || x <= 0.0 || Double.isInfinite(x)) {
            return Double.NaN;
        }
        if (Math.abs(x - 1) <= 1) {
            do {
                previous = result;
                result -= ((Math.pow(-1, n) * Math.pow(x - 1, n)) / n);
                n++;
            } while (Math.abs(result - previous) >= this.getEps() && n < 1000000);
        } else {
            do {
                previous = result;
                result -= ((Math.pow(-1, k) * Math.pow(x - 1, -k)) / k);
                k++;
            } while (Math.abs(result - previous) >= this.getEps() && k < 1000000);
            result += this.getResult(x - 1);
        }
        return result;
    }
}
