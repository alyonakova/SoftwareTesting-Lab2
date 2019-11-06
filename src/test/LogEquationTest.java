import org.junit.jupiter.api.Test;

class LogEquationTest {

    FunctionsForTest auxiliary;
    Double eps = 0.0001;

    @Test
    void test_logEquation_notExists() {
        auxiliary = new FunctionsForTest(new LogEquation(eps));
        auxiliary.checkExistence(eps, 0.0);
        auxiliary.checkExistence(eps, -5.0);
        auxiliary.checkExistence(eps, -15.0);
    }

    @Test
    void test_logEquation_exists() {
        auxiliary = new FunctionsForTest(new LogEquation(eps));
        for (Double i = 0.1; i < 3 * Math.PI; i++) {
            auxiliary.checkExistenceTrue(eps, i);
        }
    }

    @Test
    void test_logEquation_increases() {
        auxiliary = new FunctionsForTest(new LogEquation(eps));
        auxiliary.checkRange(0.1, 3 * Math.PI, 1.0);
        auxiliary.checkIncrease(0.2, 3 * Math.PI, 1.0);
    }

    @Test
    void test_logEquation_checkEquality() {
        auxiliary = new FunctionsForTest(new LogEquation(eps));
        auxiliary.checkRange( 0.1, 2 * Math.PI, 1.0);
    }
}