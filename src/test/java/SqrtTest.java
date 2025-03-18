import org.junit.jupiter.api.parallel.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

public class SqrtTest extends Conditionals {
    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @CsvSource({"1.0, 1.0", "9.0, 3.0"})
    public void testSqrtOfDoubles(double a, double exp) {
        assertEquals(exp, calculator.sqrt(a));
    }

    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @ValueSource(doubles = {-1, -10, -100})
    void testSqrtNegativeNumbers(double negative) {
        assertThrows(IllegalArgumentException.class, () -> calculator.sqrt(negative));
    }

    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @ValueSource(doubles = {Double.NaN, Double.NEGATIVE_INFINITY})
    void testSqrtWithNaNOrNegativeInfinity(double value) {
        assertThrows(IllegalArgumentException.class, () -> calculator.sqrt(value));
    }
}