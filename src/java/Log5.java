public class Log5 extends LogX {

    public Log5(Double eps) {
        super(eps);
    }

    @Override
    Double getResult(Double x) {
        return log(x, 5.0);
    }
}
