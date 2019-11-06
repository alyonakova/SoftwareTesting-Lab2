import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LnTest {

    FunctionsForTest auxiliary;
    Double eps = 0.0001;

    @Test
    void test_ln_equalsZero() {
        auxiliary = new FunctionsForTest(new Ln(eps));
        auxiliary.check(1.0, eps);
    }

    @Test
    void test_ln_equalsOne() {
        auxiliary = new FunctionsForTest(new Ln(eps));
        auxiliary.check(Math.E, eps);
    }

    @Test
    void test_ln_greaterThanZero() {
        auxiliary = new FunctionsForTest(new Ln(eps));
        Ln ln = new Ln(eps);
        auxiliary.checkRange(1.1, 3.0, 1.0);
        for (Double i = 1.1; i < 3.0; i++) {
            assertTrue(ln.getResult(i) > 0);
        }
    }

    @Test
    void test_ln_notExists() {
        auxiliary = new FunctionsForTest(new Ln(eps));
        auxiliary.checkExistence(eps, -1.0);
        auxiliary.checkExistence(eps, -8.0);
    }

}