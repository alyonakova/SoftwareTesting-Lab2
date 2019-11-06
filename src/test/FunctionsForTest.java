import static org.junit.jupiter.api.Assertions.*;

public class FunctionsForTest {

    private AbstractFunction function;

    public FunctionsForTest(AbstractFunction func) {
        this.function = func;
    }

    public void check(Double x, Double eps) {
        function.setEps(eps);
        function.setFuncIsStub(true);
        Double expected = function.getRes(x);
        function.setFuncIsStub(false);
        Double actual = function.getRes(x);
        actual = Math.round(actual * Math.pow(10,3))/Math.pow(10,3);
        expected = Math.round(expected * Math.pow(10,3))/Math.pow(10,3);
        assertTrue( (Math.abs(expected) - Math.abs(actual)) < eps, "x="+x+"actual="+actual+"expected="+expected);
    }

    public void checkRange(Double from, Double to, Double step) {
        for (Double eps = 1e-5; eps > 1e-6; eps *= 1e-1) {
            for (Double x = from; x < to; x += step) {
                check(x, eps);
            }
        }
    }

    public void checkExistence(Double eps, Double point) {
        function.setEps(eps);
        function.setFuncIsStub(false);
        assertTrue(Double.isNaN(function.getRes(point)));
    }

    public void checkExistenceTrue(Double eps, Double point) {
        function.setEps(eps);
        function.setFuncIsStub(false);
        assertFalse(Double.isNaN(function.getRes(point)));
    }

    void checkIncrease(Double from, Double to, Double step) {
        Double previous = from - 0.1;
        for (Double i = from; i < to;  i += step) {
            Double actualValue = function.getRes(i);
            Double previousActualValue = function.getRes(previous);
            assertTrue(previousActualValue < actualValue, "i="+ i + ", " + previousActualValue + " < " + actualValue);
            previous = i;
        }
    }

    void checkDecrease(Double from, Double to, Double step) {
        Double previous = from - 0.1;
        for (Double i = from; i < to;  i += step) {
            Double actualValue = function.getRes(i);
            Double previousActualValue = function.getRes(previous);
            assertTrue(previousActualValue > actualValue, "" + previousActualValue + " > " + actualValue);
            previous = i;
        }
    }
}
