public class Sec extends AbstractFunction {

    private Cos cos;

    public Sec(Double eps) {
        super(eps);
        cos = new Cos(eps);
    }

    @Override
    public void setEps(Double eps){
        super.setEps(eps);
        cos.setEps(eps);
    }

    @Override
    public Double getResult(Double x) {
        return  Math.abs(cos.getResult(x)) < this.getEps() ? Double.NaN : 1 / cos.getResult(x);
    }
}
