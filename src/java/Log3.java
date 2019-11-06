public class Log3 extends LogX {

    public Log3(Double eps) {
        super(eps);
    }

    @Override
    Double getResult(Double x) {
        return log(x, 3.0);
    }
}
