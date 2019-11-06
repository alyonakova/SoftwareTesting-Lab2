public class Cosec extends AbstractFunction {

    private Sin sin;

    public Cosec(Double eps) {
        super(eps);
        sin = new Sin(eps);
    }

    @Override
    public void setEps(Double eps){
        super.setEps(eps);
        sin.setEps(eps);
    }

    @Override
    public Double getResult(Double x) {
        /*
        if (Math.abs(x - Math.PI) < this.getEps()) {
            return Double.NaN;
        }
        if (Math.abs(x + Math.PI) < this.getEps()) {
            return Double.NaN;
        }
        if (Double.isNaN(x) || Double.isInfinite(x)) {
            return Double.NaN;
        }

         */
        return Math.abs(sin.getResult(x)) < this.getEps() ? Double.NaN : 1 / sin.getResult(x);
    }
}
