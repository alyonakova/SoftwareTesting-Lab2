public class LogX extends AbstractFunction {

    private Ln ln;
   // private boolean isStub = true;
    public LogX(Double eps) {
        super(eps);
        ln = new Ln(eps);
    }
    @Override
    Double getResult(Double arg) {
        return 0.0;
    }

    @Override
    public void setEps(Double eps) {
        super.setEps(eps);
        ln.setEps(eps);
    }


     Double log(Double x, Double base) {
        if (base < 0 || base == 1) {
            throw new IllegalArgumentException();
        }

        if (Math.abs(x - base) < this.getEps()) {
            return 1.0;
        }

        if (Math.abs(x - 1d) < this.getEps()) {
            return 0.0;
        }

        if (x == 0.0) {
            return Double.NaN;
        }
        return ln.getResult(x) / ln.getResult(base);
    }

}
