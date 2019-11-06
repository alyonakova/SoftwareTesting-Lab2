public class Log10 extends LogX {

    public Log10(Double eps) {
        super(eps);
    }

    @Override
    Double getResult(Double x) {
        return log(x, 10.0);
    }
}
