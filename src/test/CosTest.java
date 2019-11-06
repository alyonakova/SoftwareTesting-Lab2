import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CosTest {

    FunctionsForTest auxiliary;
    Double eps = 0.0001;

    @Test
    void test_cos_greaterThanZeroFromMinPi_2ToPi_2() {
        auxiliary = new FunctionsForTest(new Cos(eps));
        Cos cos = new Cos(eps);
        auxiliary.checkRange(-Math.PI / 2 + 0.1, Math.PI / 2, 1.0);
        for (Double i = -Math.PI / 2 + 0.1; i < Math.PI / 2; i++) {
            assertTrue(cos.getResult(i) > 0);
        }
    }

    @Test
    void test_cos_greaterThanZeroFrom3Pi_2To5Pi_2() {
        auxiliary = new FunctionsForTest(new Cos(eps));
        Cos cos = new Cos(eps);
        auxiliary.checkRange(3*Math.PI / 2 + 0.1, 5*Math.PI / 2, 1.0);
        for (Double i = 3*Math.PI / 2 + 0.1; i < 5*Math.PI / 2; i++) {
            assertTrue(cos.getResult(i) > 0);
        }
    }

    @Test
    void test_cos_lessThanZeroFromPi_2To3Pi_2() {
        auxiliary = new FunctionsForTest(new Cos(eps));
        Cos cos = new Cos(eps);
        auxiliary.checkRange(Math.PI / 2 + 0.1, 3 * Math.PI / 2, 1.0);
        for (Double i = Math.PI / 2 + 0.1; i < 3 * Math.PI / 2; i++) {
            assertTrue(cos.getResult(i) < 0);
        }
    }

    @Test
    void test_cos_increases() {
        auxiliary = new FunctionsForTest(new Cos(eps));
        auxiliary.checkRange(Math.PI + 0.1, Math.PI * 2, 1.0);
        auxiliary.checkIncrease(Math.PI + 0.1, Math.PI * 2, 1.0);
    }

    @Test
    void test_cos_decreases() {
        auxiliary = new FunctionsForTest(new Cos(eps));
        auxiliary.checkRange(0.11, Math.PI, 1.0);
        auxiliary.checkDecrease(0.11, Math.PI, 1.0);
    }
}