import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CosecTest {

    FunctionsForTest auxiliary;
    Double eps = 0.0001;

    @Test
    void test_cosec_greaterThanZeroFrom0ToPi() {
        auxiliary = new FunctionsForTest(new Cosec(eps));
        Cosec cosec = new Cosec(eps);
        auxiliary.checkRange(0.11,  Math.PI, 1.0);
        for (Double i = 0.1; i < Math.PI ; i++) {
            assertTrue(cosec.getResult(i) > 0);
        }
    }

    @Test
    void test_cosec_lessThanZeroFromPiTo2Pi() {
        auxiliary = new FunctionsForTest(new Cosec(eps));
        Cosec cosec = new Cosec(eps);
        auxiliary.checkRange(Math.PI + 0.1,  2*Math.PI, 1.0);
        for (Double i = Math.PI + 0.1; i < 2*Math.PI ; i++) {
            assertTrue(cosec.getResult(i) < 0);
        }
    }

    @Test
    void test_cosec_notExistsInPi() {
        auxiliary = new FunctionsForTest(new Cosec(eps));
        auxiliary.checkExistence(eps, Math.PI);
    }

    @Test
    void test_cosec_notExistsIn0() {
        auxiliary = new FunctionsForTest(new Cosec(eps));
        auxiliary.checkExistence(eps, 0.0);
    }
}