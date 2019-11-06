import java.util.ArrayList;
import java.util.function.Function;

public class Actions {

    private SystemOfEquations system;
    private Sin sin;
    private Cos cos;
    private Tan tan;
    private Cot cot;
    private Sec sec;
    private Cosec cosec;
    private Ln ln;
    private Log3 log3;
    private Log5 log5;
    private Log10 log10;
    private TrigonometricEquation trigEq;
    private LogEquation logEq;
    private ArrayList<Function<Double, Double>> acts;
    private Double eps = 0.0001;

    public Actions() {
        system = new SystemOfEquations(eps);
        sin = new Sin(eps);
        cos = new Cos(eps);
        tan = new Tan(eps);
        cot = new Cot(eps);
        sec = new Sec(eps);
        cosec = new Cosec(eps);
        ln = new Ln(eps);
        log3 = new Log3(eps);
        log5 = new Log5(eps);
        log10 = new Log10(eps);
        trigEq = new TrigonometricEquation(eps);
        logEq = new LogEquation(eps);
        acts = new ArrayList<>();

        acts.add(x -> sin.getResult(x));
        acts.add(x -> cos.getResult(x));
        acts.add(x -> tan.getResult(x));
        acts.add(x -> cot.getResult(x));
        acts.add(x -> sec.getResult(x));
        acts.add(x -> cosec.getResult(x));

        acts.add(x -> ln.getResult(x));
        acts.add(x -> log3.getResult(x));
        acts.add(x -> log5.getResult(x));
        acts.add(x -> log10.getResult(x));

        acts.add(x -> trigEq.getResult(x));
        acts.add(x -> logEq.getResult(x));
        acts.add(x -> system.getResult(x));
    }

    public ArrayList<Function<Double, Double>> getActs() {
        return this.acts;
    }
}
