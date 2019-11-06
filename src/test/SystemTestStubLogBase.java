import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SystemTestStubLogBase {

    FunctionsForTest auxiliary;
    Double eps = 0.0001;

    @Test
    void test_system_xLessThanOrEqualsZero() {
        Ln ln = new Ln(eps);
        ln.setFuncIsStub(true);
        LogEquation logEq = new LogEquation(ln, eps);
        logEq.setFuncIsStub(false);
        TrigonometricEquation trEq = new TrigonometricEquation(eps);
        trEq.setFuncIsStub(false);
        SystemOfEquations syst = new SystemOfEquations(trEq, logEq, eps);
        auxiliary = new FunctionsForTest(syst);
        auxiliary.checkRange((-2) * Math.PI, 0.0, 1.0);
    }

    @Test
    void test_system_xGreaterThanZero() {
        Ln ln = new Ln(eps);
        ln.setFuncIsStub(true);
        LogEquation logEq = new LogEquation(ln, eps);
        logEq.setFuncIsStub(false);
        TrigonometricEquation trEq = new TrigonometricEquation(eps);
        trEq.setFuncIsStub(false);
        SystemOfEquations syst = new SystemOfEquations(trEq, logEq, eps);
        auxiliary = new FunctionsForTest(syst);
        auxiliary.checkRange(0.1, 2*Math.PI, 1.0);
    }

    @Test
    void test_system_xZero() {
        Ln ln = new Ln(eps);
        ln.setFuncIsStub(true);
        LogEquation logEq = new LogEquation(ln, eps);
        logEq.setFuncIsStub(false);
        TrigonometricEquation trEq = new TrigonometricEquation(eps);
        trEq.setFuncIsStub(false);
        SystemOfEquations syst = new SystemOfEquations(trEq, logEq, eps);
        auxiliary = new FunctionsForTest(syst);
        auxiliary.checkExistence(eps, 0.0);
    }

    @Test
    void test_system_trigFuncExecutes() {
        SystemOfEquations syst = new SystemOfEquations(eps);
        TrigonometricEquation trEq = new TrigonometricEquation(eps);
        for (Double x = (-2) * Math.PI; x < 0.0; x++) {
            assertEquals(syst.getResult(x), trEq.getResult(x));
        }
    }

    @Test
    void test_system_logFuncExecutes() {
        SystemOfEquations syst = new SystemOfEquations(eps);
        Ln ln = new Ln(eps);
        ln.setFuncIsStub(true);
        LogEquation logEq = new LogEquation(ln, eps);
        logEq.setFuncIsStub(false);
        for (Double x = 0.1; x < 6; x++) {
            assertEquals(syst.getResult(x), logEq.getResult(x));
        }
    }
}
