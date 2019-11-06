import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecTest {

    FunctionsForTest auxiliary;
    Double eps = 0.0001;

    @Test
    void test_sec_greaterThanZeroFrom0ToPi() {
        auxiliary = new FunctionsForTest(new Sec(eps));
        Sec sec = new Sec(eps);
        auxiliary.checkRange(-Math.PI/2 + 0.1, Math.PI/2, 1.0);
        for (Double i = -Math.PI/2 + 0.1; i < Math.PI/2 ; i++) {
            assertTrue(sec.getResult(i) > 0);
        }
    }

    @Test
    void test_sec_lessThanZeroFromPi_2To3Pi_2() {
        auxiliary = new FunctionsForTest(new Sec(eps));
        Sec sec = new Sec(eps);
        auxiliary.checkRange(Math.PI/2 + 0.1,  3*Math.PI/2, 1.0);
        for (Double i = Math.PI/2 + 0.1; i < 3*Math.PI/2 ; i++) {
            assertTrue(sec.getResult(i) < 0);
        }
    }

    @Test
    void test_sec_notExistsInPi_2() {
        auxiliary = new FunctionsForTest(new Sec(eps));
        auxiliary.checkExistence(eps, Math.PI/2);
    }

    @Test
    void test_sec_notExistsInMinPi_2() {
        auxiliary = new FunctionsForTest(new Sec(eps));
        auxiliary.checkExistence(eps, -Math.PI/2);
    }

}