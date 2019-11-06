import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SystemTestStubTrigBase_LogBase {

    FunctionsForTest auxiliary;
    Double eps = 0.0001;

    @Test
    void test_system_xLessThanOrEqualsZero() {
        Sin sin = new Sin(eps);
        sin.setFuncIsStub(true);
        TrigonometricEquation trEq = new TrigonometricEquation(sin, eps);
        trEq.setFuncIsStub(false);
        Ln ln = new Ln(eps);
        ln.setFuncIsStub(true);
        LogEquation logEq = new LogEquation(ln, eps);
        logEq.setFuncIsStub(false);
        SystemOfEquations syst = new SystemOfEquations(trEq, logEq, eps);
        auxiliary = new FunctionsForTest(syst);
        auxiliary.checkRange((-2) * Math.PI, 0.0, 1.0);
    }

    @Test
    void test_system_xGreaterThanZero() {
        Sin sin = new Sin(eps);
        sin.setFuncIsStub(true);
        TrigonometricEquation trEq = new TrigonometricEquation(sin, eps);
        trEq.setFuncIsStub(false);
        Ln ln = new Ln(eps);
        ln.setFuncIsStub(true);
        LogEquation logEq = new LogEquation(ln, eps);
        logEq.setFuncIsStub(false);
        SystemOfEquations syst = new SystemOfEquations(trEq, logEq, eps);
        auxiliary = new FunctionsForTest(syst);
        auxiliary.checkRange(0.1, 2*Math.PI, 1.0);
    }

    @Test
    void test_system_xZero() {
        Sin sin = new Sin(eps);
        sin.setFuncIsStub(true);
        TrigonometricEquation trEq = new TrigonometricEquation(sin, eps);
        trEq.setFuncIsStub(false);
        Ln ln = new Ln(eps);
        ln.setFuncIsStub(true);
        LogEquation logEq = new LogEquation(ln, eps);
        logEq.setFuncIsStub(false);
        SystemOfEquations syst = new SystemOfEquations(trEq, logEq, eps);
        auxiliary = new FunctionsForTest(syst);
        auxiliary.checkExistence(eps, 0.0);
    }

    @Test
    void test_system_trigFuncExecutes() {
        Sin sin = new Sin(eps);
        sin.setFuncIsStub(true);
        TrigonometricEquation trEq = new TrigonometricEquation(sin, eps);
        trEq.setFuncIsStub(false);
        Ln ln = new Ln(eps);
        ln.setFuncIsStub(true);
        LogEquation logEq = new LogEquation(ln, eps);
        logEq.setFuncIsStub(false);
        SystemOfEquations syst = new SystemOfEquations(trEq, logEq, eps);
        for (Double x = (-1) * Math.PI; x < 0.0; x++) {
            assertEquals(syst.getResult(x), trEq.getResult(x), "x=" + x);
        }
    }

    @Test
    void test_system_logFuncExecutes() {
        Sin sin = new Sin(eps);
        sin.setFuncIsStub(true);
        TrigonometricEquation trEq = new TrigonometricEquation(sin, eps);
        trEq.setFuncIsStub(false);
        Ln ln = new Ln(eps);
        ln.setFuncIsStub(true);
        LogEquation logEq = new LogEquation(ln, eps);
        logEq.setFuncIsStub(false);
        SystemOfEquations syst = new SystemOfEquations(trEq, logEq, eps);
        for (Double x = 0.1; x < 6; x++) {
            assertEquals(syst.getResult(x), logEq.getResult(x));
        }
    }
}
