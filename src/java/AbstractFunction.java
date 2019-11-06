public abstract class AbstractFunction {

    private final Double epsDefault = 0.000001;
    private Boolean funcIsStub = false;

    private Double eps;

    public AbstractFunction() {
        this.eps = epsDefault;
    }

    AbstractFunction(Double eps) {
        this.eps = eps;
    }

    public Double getEps() {
        return this.eps;
    }

    public void setEps(Double eps) {
        this.eps = eps;
    }


    public void setFuncIsStub(boolean IsStub) {
        this.funcIsStub = IsStub;
    }

    Double stub(Double x) {
        if (this.getClass().getName().toString().equals(Cos.class.getName().toString())) {
            return Math.cos(x);
        } else if (this.getClass().getName().toString().equals(Cosec.class.getName().toString())) {
            return 1/Math.sin(x);
        } else if (this.getClass().getName().toString().equals(Cot.class.getName().toString())) {
            return Math.cos(x)/Math.sin(x);
        } else if (this.getClass().getName().toString().equals(Ln.class.getName().toString())) {
            return Math.log(x);
        } else if (this.getClass().getName().toString().equals(Log3.class.getName().toString())) {
            return Math.log(x)/Math.log(3);
        } else if (this.getClass().getName().toString().equals(Log5.class.getName().toString())) {
            return Math.log(x)/Math.log(5);
        } else if (this.getClass().getName().toString().equals(Log10.class.getName().toString())) {
            return Math.log(x)/Math.log(10);
        } else  if (this.getClass().getName().toString().equals(Sec.class.getName().toString())) {
            return 1/Math.cos(x);
        } else if (this.getClass().getName().toString().equals(Sin.class.getName().toString())) {
            return Math.sin(x);
        } else  if (this.getClass().getName().toString().equals(Tan.class.getName().toString())) {
            return Math.sin(x)/ Math.cos(x);
        } else if (this.getClass().getName().toString().equals(LogEquation.class.getName().toString())) {
            return  (((((Math.log(x)/Math.log(3) - Math.log(x)/Math.log(10)) / Math.log(x)) + Math.log(x)/Math.log(3))
                    + Math.log(x)/Math.log(5)) + Math.log(x)/Math.log(5));
        } else if (this.getClass().getName().toString().equals(TrigonometricEquation.class.getName().toString())) {
            Double result = ((((Math.tan(x)/Math.cos(x)) * Math.tan(x))/(1/Math.sin(x)))
                    + (Math.pow((Math.cos(x)/Math.sin(x) - (1/Math.cos(x))), 3) + (1/Math.cos(x)))) *
                    (Math.sin(x) + Math.cos(x)/Math.sin(x) - 1/Math.cos(x));
            return Double.isInfinite(result) ? Double.NaN : result;
        } else return Double.NaN;
    }


    abstract Double getResult(Double x);

    public Double getRes(Double x) {
        if (this.funcIsStub) {
            return stub(x);
        } else {
            return getResult(x);
        }
    }
}
