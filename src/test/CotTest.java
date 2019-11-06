import org.junit.jupiter.api.Test;

class CotTest {

    FunctionsForTest auxiliary;
    Double eps = 0.0001;

    @Test
    void test_cot_existsFromPiTo2Pi() {
        auxiliary = new FunctionsForTest(new Cot(eps));
        auxiliary.checkRange(Math.PI + 0.1, 2*Math.PI, 1.0);
    }

    @Test
    void test_cot_existsFrom0ToPi() {
        auxiliary = new FunctionsForTest(new Cot(eps));
        auxiliary.checkRange( 0.1, Math.PI, 1.0);
    }

    @Test
    void test_cot_notExistsInPi() {
        auxiliary = new FunctionsForTest(new Cot(eps));
        auxiliary.checkExistence(eps, Math.PI);
    }

    @Test
    void test_tg_notExistsIn0() {
        auxiliary = new FunctionsForTest(new Cot(eps));
        auxiliary.checkExistence(eps, 0.0);
    }
}