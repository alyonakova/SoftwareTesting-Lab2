import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinTest {

    FunctionsForTest auxiliary;
    Double eps = 0.0001;

    @Test
    void test_sin_greaterThanZeroFrom0ToPi() {
        auxiliary = new FunctionsForTest(new Sin(eps));
        Sin sin = new Sin(eps);
        auxiliary.checkRange(0.1, Math.PI, 1.0);
        for (Double i = 0.1; i < Math.PI; i++) {
            assertTrue(sin.getResult(i) > 0);
        }
    }

    @Test
    void test_sin_greaterThanZeroFrom2PiTo3Pi() {
        auxiliary = new FunctionsForTest(new Sin(eps));
        Sin sin = new Sin(eps);
        auxiliary.checkRange(2 * Math.PI, 3* Math.PI, 1.0);
        for (Double i = 2 * Math.PI; i < 3* Math.PI; i++) {
            assertTrue(sin.getResult(i) > 0);
        }
    }

    @Test
    void test_sin_lessThanZeroFromPiTo2Pi() {
        auxiliary = new FunctionsForTest(new Sin(eps));
        Sin sin = new Sin(eps);
        auxiliary.checkRange(Math.PI + 0.1, 2 * Math.PI, 1.0);
        for (Double i = Math.PI + 0.1; i < 2 * Math.PI; i++) {
            assertTrue(sin.getResult(i) < 0);
        }
    }

    @Test
    void test_sin_lessThanZeroFromMinPiTo0() {
        auxiliary = new FunctionsForTest(new Sin(eps));
        Sin sin = new Sin(eps);
        auxiliary.checkRange(-Math.PI + 0.1, 0.0, 1.0);
        for (Double i = -Math.PI + 0.1; i < 0.0; i++) {
            assertTrue(sin.getResult(i) < 0);
        }
    }

    @Test
    void test_sin_increases() {
        auxiliary = new FunctionsForTest(new Sin(eps));
        auxiliary.checkRange(-Math.PI/2 + 0.1, Math.PI/2, 1.0);
        auxiliary.checkIncrease(-Math.PI/2 + 0.1, Math.PI/2, 1.0);
    }

    @Test
    void test_sin_decreases() {
        auxiliary = new FunctionsForTest(new Sin(eps));
        auxiliary.checkRange(Math.PI/2 + 0.1, 3*Math.PI/2, 1.0);
        auxiliary.checkDecrease(Math.PI/2 + 0.1, 3*Math.PI/2, 1.0);
    }
}