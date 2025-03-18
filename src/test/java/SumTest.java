import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class SumTest extends Conditionals {
    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @CsvSource({"1, 4, 5", "-5, -3, -8"})
    public void testSumOfLongs(long a, long b, long exp) {
        assertEquals(exp, calculator.sum(a, b));
    }

    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @CsvSource({"1.0, 4.5, 5.5", "-4.8, -3.0, -7.8"})
    public void testSumOfDoubles(double a, double b, double exp) {
        assertEquals(exp, calculator.sum(a, b));
    }

    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @ValueSource(doubles = {Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY})
    void testSumInvalidInputs(double invalid) {
        assertThrows(IllegalArgumentException.class, () -> calculator.sum(invalid, 10));
    }

    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @CsvSource({"9223372036854775806, 1, 9223372036854775807", "-9223372036854775807, -1, -9223372036854775808"})
    public void testSumOfLongsValidCases(long a, long b, long exp) {
        assertEquals(exp, calculator.sum(a, b));
    }

    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @CsvSource({"9223372036854775807, 1", "-9223372036854775808, -1"})
    void testSumOfLongsOverflow(long a, long b) {
        assertThrows(ArithmeticException.class, () -> calculator.sum(a, b));
    }

}
