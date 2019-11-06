import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrigonometricEquationTest {

    FunctionsForTest auxiliary;
    Double eps = 0.0001;


    @Test
    void test_trigEquation_greaterThanZero_1() {
        auxiliary = new FunctionsForTest(new TrigonometricEquation(eps));
        TrigonometricEquation trEq = new TrigonometricEquation(eps);
        auxiliary.checkRange(-Math.PI + 0.1, -Math.PI / 2, 1.0);
        for (Double i = -Math.PI + 0.1; i < -Math.PI/2; i++) {
            assertTrue(trEq.getRes(i) >= 0);
        }
    }

    @Test
    void test_trigEquation_greaterThanZero_2() {
        auxiliary = new FunctionsForTest(new TrigonometricEquation(eps));
        TrigonometricEquation trEq = new TrigonometricEquation(eps);
        auxiliary.checkRange(-Math.PI / 2 + 0.1, 0.0, 1.0);
        for (Double i = -Math.PI / 2 + 0.1; i < 0.0; i++) {
            assertTrue(trEq.getResult(i) >= 0);
        }
    }

    @Test
    void test_trigEquation_increases() {
        auxiliary = new FunctionsForTest(new TrigonometricEquation(eps));
        auxiliary.checkRange(Math.PI/2 + 0.1, Math.PI, 1.0);
        auxiliary.checkIncrease(Math.PI/2 + 0.2, Math.PI, 1.0);
    }

    @Test
    void test_trigEquation_decreases() {
        auxiliary = new FunctionsForTest(new TrigonometricEquation(eps));
        auxiliary.checkRange(0.1, Math.PI/2, 1.0);
        auxiliary.checkDecrease(0.2, Math.PI/2, 1.0);
    }

    @Test
    void test_trigEquation_notExists() {
        auxiliary = new FunctionsForTest(new TrigonometricEquation(eps));
        auxiliary.checkExistence(eps, Math.PI/2);
    }
}