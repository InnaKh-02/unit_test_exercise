import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CtgTest extends Conditionals {
    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @CsvSource({"1.0, 0.6421", "0.5, 1.8305"})
    public void testCtgOfDoubles(double a, double exp) {
        assertEquals(exp, calculator.ctg(a), 0.0001);
    }

    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @ValueSource(doubles = {Math.PI, 2 * Math.PI})
    public void testCtgUndefined(double angle) {
        assertThrows(ArithmeticException.class, () -> calculator.ctg(angle));
    }

    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @ValueSource(doubles = {Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY})
    public void testCtgInvalidInputs(double invalid) {
        assertThrows(IllegalArgumentException.class, () -> calculator.ctg(invalid));
    }
}