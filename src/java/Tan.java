public class Tan extends AbstractFunction {

    private Cos cos;
    private Sin sin;

    public Tan(Double eps) {
        super(eps);
        cos = new Cos(eps);
        sin = new Sin(eps);
    }

    @Override
    public void setEps(Double eps){
        super.setEps(eps);
        cos.setEps(eps);
        sin.setEps(eps);
    }

    @Override
    public Double getResult(Double x) {
        return  Math.abs(cos.getResult(x)) < this.getEps() ? Double.NaN : sin.getResult(x) / cos.getResult(x);
    }
}
