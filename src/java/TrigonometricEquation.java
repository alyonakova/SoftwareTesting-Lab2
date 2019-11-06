public class TrigonometricEquation extends AbstractFunction{
    private Double eps;
    private Cos cos;
    private Sin sin;
    private Tan tan;
    private Cot cot;
    private Sec sec;
    private Cosec cosec;

    public TrigonometricEquation(Double eps) {
        super(eps);
        this.eps = eps;
        cos = new Cos(eps);
        sin = new Sin(eps);
        sec = new Sec(eps);
        tan = new Tan(eps);
        cot = new Cot(eps);
        cosec = new Cosec(eps);
    }

    TrigonometricEquation(Sin sinus, Double eps) {
        super(eps);
        this.eps = eps;
        cos = new Cos(eps);
        sin = sinus;
        sec = new Sec(eps);
        tan = new Tan(eps);
        cot = new Cot(eps);
        cosec = new Cosec(eps);
    }

    @Override
    public void setEps(Double eps) {
        super.setEps(eps);
        cos.setEps(eps);
        sin.setEps(eps);
        sec.setEps(eps);
        tan.setEps(eps);
        cot.setEps(eps);
        cosec.setEps(eps);
    }

    @Override
    public Double getResult(Double x) {
        return act_3(x) * act_4(x);
    }

    public Double act_1(Double x) {
        return ((tan.getRes(x)/cos.getRes(x)) * tan.getRes(x))/(1/sin.getRes(x));
    }

    public Double act_2(Double x) {
        return Math.pow(((cos.getRes(x)/sin.getRes(x)) - (1/cos.getRes(x))), 3) + 1/cos.getRes(x);
    }

    public Double act_3(Double x) {
        return act_1(x) + act_2(x);
    }

    public Double act_4(Double x) {
        return sin.getRes(x) + cos.getRes(x)/sin.getRes(x) - 1/cos.getRes(x);
    }
}
