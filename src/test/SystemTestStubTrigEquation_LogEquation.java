import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SystemTestStubTrigEquation_LogEquation {

    FunctionsForTest auxiliary;
    Double eps = 0.0001;

    @Test
    void test_system_xLessThanOrEqualsZero() {
        TrigonometricEquation trEq = new TrigonometricEquation(eps);
        trEq.setFuncIsStub(true);
        LogEquation logEq = new LogEquation(eps);
        logEq.setFuncIsStub(true);
        SystemOfEquations syst = new SystemOfEquations(trEq, logEq, eps);
        auxiliary = new FunctionsForTest(syst);
        auxiliary.checkRange((-2) * Math.PI, 0.0, 1.0);
    }

    @Test
    void test_system_xGreaterThanZero() {
        TrigonometricEquation trEq = new TrigonometricEquation(eps);
        trEq.setFuncIsStub(true);
        LogEquation logEq = new LogEquation(eps);
        logEq.setFuncIsStub(true);
        SystemOfEquations syst = new SystemOfEquations(trEq, logEq, eps);
        auxiliary = new FunctionsForTest(syst);
        auxiliary.checkRange(0.1, 2*Math.PI, 1.0);
    }

    @Test
    void test_system_xZero() {
        TrigonometricEquation trEq = new TrigonometricEquation(eps);
        trEq.setFuncIsStub(true);
        LogEquation logEq = new LogEquation(eps);
        logEq.setFuncIsStub(true);
        SystemOfEquations syst = new SystemOfEquations(trEq, logEq, eps);
        auxiliary = new FunctionsForTest(syst);
        auxiliary.checkExistence(eps, 0.0);
    }

    @Test
    void test_system_trigFuncExecutes() {
        TrigonometricEquation trEq = new TrigonometricEquation(eps);
        trEq.setFuncIsStub(true);
        LogEquation logEq = new LogEquation(eps);
        logEq.setFuncIsStub(true);
        SystemOfEquations syst = new SystemOfEquations(trEq, logEq, eps);
        for (Double x = (-2) * Math.PI; x < 0.0; x++) {
            assertEquals(syst.getResult(x), trEq.getResult(x));
        }
    }

    @Test
    void test_system_logFuncExecutes() {
        TrigonometricEquation trEq = new TrigonometricEquation(eps);
        trEq.setFuncIsStub(true);
        LogEquation logEq = new LogEquation(eps);
        logEq.setFuncIsStub(true);
        SystemOfEquations syst = new SystemOfEquations(trEq, logEq, eps);
        for (Double x = 0.1; x < 6; x++) {
            assertEquals(syst.getResult(x), logEq.getResult(x));
        }
    }
}
