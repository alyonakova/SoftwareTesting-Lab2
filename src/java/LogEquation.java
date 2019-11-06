public class LogEquation extends AbstractFunction {

    private Double eps;
    private Ln ln;
    private Log3 log3;
    private Log5 log5;
    private Log10 log10;

    public LogEquation(Double eps) {
        super(eps);
        this.eps = eps;
        ln = new Ln(eps);
        log3 = new Log3(eps);
        log5 = new Log5(eps);
        log10 = new Log10(eps);
    }

    LogEquation(Ln log, Double eps) {
        super(eps);
        this.eps = eps;
        ln = log;
        log3 = new Log3(eps);
        log5 = new Log5(eps);
        log10 = new Log10(eps);
    }

    @Override
    public void setEps(Double eps) {
        super.setEps(eps);
        ln.setEps(eps);
        log3.setEps(eps);
        log5.setEps(eps);
        log10.setEps(eps);
    }

    @Override
    public Double getResult(Double x) {
        return ((log3.getResult(x) - log10.getResult(x))/ln.getResult(x)) +
                log3.getResult(x) + log5.getResult(x) + log5.getResult(x);
    }
}
