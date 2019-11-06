public class SystemOfEquations extends AbstractFunction {

    private Double eps;
    private TrigonometricEquation trigEquation;
    private LogEquation logEquation;

    SystemOfEquations(Double eps) {
        super(eps);
        this.eps = eps;
        trigEquation = new TrigonometricEquation(eps);
        logEquation = new LogEquation(eps);
    }

    SystemOfEquations(TrigonometricEquation tr, LogEquation lg, Double eps) {
        super(eps);
        this.eps = eps;
        trigEquation = tr;
        logEquation = lg;
    }

    @Override
    public void setEps(Double eps) {
        super.setEps(eps);
        trigEquation.setEps(eps);
        logEquation.setEps(eps);
    }

    @Override
    public Double getResult(Double x) {
        if(x <= 0) {
            if (Double.isInfinite(trigEquation.getResult(x))) return Double.NaN;
            return trigEquation.getResult(x);
        } else {
            return logEquation.getResult(x);
        }
    }
}
