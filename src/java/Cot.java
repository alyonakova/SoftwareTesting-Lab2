public class Cot extends AbstractFunction{
    private Cos cos;
    private Sin sin;

    public Cot(Double eps) {
        super(eps);
        sin = new Sin(eps);
        cos = new Cos(eps);
    }

    @Override
    public void setEps(Double eps){
        super.setEps(eps);
        cos.setEps(eps);
        sin.setEps(eps);
    }

    @Override
    public Double getResult(Double x) {
        return Math.abs(sin.getResult(x)) < this.getEps() ? Double.NaN : cos.getResult(x) / sin.getResult(x);
    }
}
