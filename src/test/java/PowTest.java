import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class PowTest extends Conditionals {
    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @CsvSource({"2.0, -2.0, 0.25", "2.0, 2.0, 4.0", "0.0, 0.0, 1.0", "0.0, 2.0, 0.0"})
    public void testPowOfDoubles(double a, double b, double exp) {
        assertEquals(exp, calculator.pow(a, b));
    }

    @ParameterizedTest
    @CsvSource({"NaN, 2", "2, NaN", "Infinity, 2", "2, Infinity", "-Infinity, 2"})
    void testPowWithNaNOrInfinity(double base, double exponent) {
        assertThrows(IllegalArgumentException.class, () -> calculator.pow(base, exponent));
    }
}