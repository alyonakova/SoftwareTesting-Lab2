import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SystemOfEquationsTest {

    FunctionsForTest auxiliary;
    Double eps = 0.0001;

    @Test
    void test_system_xLessThanOrEqualsZero() {
        auxiliary = new FunctionsForTest(new SystemOfEquations(eps));
        auxiliary.checkRange((-2) * Math.PI, 0.0, 1.0);
    }

    @Test
    void test_system_xGreaterThanZero() {
        auxiliary = new FunctionsForTest(new SystemOfEquations(eps));
        auxiliary.checkRange(0.1, 2*Math.PI, 1.0);
    }

    @Test
    void test_system_xZero() {
        auxiliary = new FunctionsForTest(new SystemOfEquations(eps));
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
        LogEquation logEq = new LogEquation(eps);
        for (Double x = 0.1; x < 6; x++) {
            assertEquals(syst.getResult(x), logEq.getResult(x));
        }
    }
}