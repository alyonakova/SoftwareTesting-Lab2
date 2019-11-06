import org.junit.jupiter.api.Test;

class TanTest {

    FunctionsForTest auxiliary;
    Double eps = 0.0001;

    @Test
    void test_tg_existsFromPi_2to3Pi_2() {
        auxiliary = new FunctionsForTest(new Tan(eps));
        auxiliary.checkRange(Math.PI/2 + 0.1, 3*Math.PI/2, 1.0);
    }

    @Test
    void test_tg_existsFrom3Pi_2toPi_2() {
        auxiliary = new FunctionsForTest(new Tan(eps));
        auxiliary.checkRange(3*Math.PI/2 + 0.1, Math.PI/2, 1.0);
    }

    @Test
    void test_tg_notExistsInPi_2() {
        auxiliary = new FunctionsForTest(new Tan(eps));
        auxiliary.checkExistence(eps, Math.PI/2);
    }

    @Test
    void test_tg_notExistsIn3Pi_2() {
        auxiliary = new FunctionsForTest(new Tan(eps));
        auxiliary.checkExistence(eps, 3*Math.PI/2);
    }
}