public class Cos extends AbstractFunction{

    private Sin sin;

    public Cos(Double eps) {
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
        if (x == 0) return 1.0;
        return sin.getResult(2 * x) / (2 * sin.getResult(x));
    }
}
