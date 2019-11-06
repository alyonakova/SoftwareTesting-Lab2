import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Log3Test {

    FunctionsForTest auxiliary;
    Double eps = 0.0001;

    @Test
    void test_log3_equalsZero() {
        auxiliary = new FunctionsForTest(new Log3(eps));
        auxiliary.check(1.0, eps);
    }

    @Test
    void test_log3_equalsOne() {
        auxiliary = new FunctionsForTest(new Log3(eps));
        auxiliary.check(Math.E, eps);
    }

    @Test
    void test_log3_greaterThanZero() {
        auxiliary = new FunctionsForTest(new Log3(eps));
        Log3 log3 = new Log3(eps);
        auxiliary.checkRange(1.1, 3.0, 1.0);
        for (Double i = 1.1; i < 3.0; i++) {
            assertTrue(log3.getResult(i) > 0);
        }
    }

    @Test
    void test_log3_notExists() {
        auxiliary = new FunctionsForTest(new Log3(eps));
        auxiliary.checkExistence(eps, -1.0);
        auxiliary.checkExistence(eps, -8.0);
    }

}