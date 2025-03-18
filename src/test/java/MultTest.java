import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MultTest extends Conditionals {
    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @CsvSource({"1, 4, 4", "-5, -3, 15"})
    public void testMultOfLongs(long a, long b, long exp) {
        assertEquals(exp, calculator.mult(a, b));
    }

    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @CsvSource({"1.0, 4.5, 4.5", "-4.8, -3.0, 14.4"})
    public void testMultOfDoubles(double a, double b, double exp) {
        assertEquals(exp, calculator.mult(a, b), 0.0001);
    }

    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @ValueSource(doubles = {Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY})
    void testMultInvalidInputs(double invalid) {
        assertThrows(IllegalArgumentException.class, () -> calculator.mult(invalid, 10));
    }
    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @CsvSource({
            "9223372036854775807, 2",  // Long.MAX_VALUE * 2
            "-9223372036854775808, 2", // Long.MIN_VALUE * 2
            "9223372036854775807, -2", // Long.MAX_VALUE * -2
            "-9223372036854775808, -2" // Long.MIN_VALUE * -2
    })
    void testMultLongOverflow(long a, long b) {
        assertThrows(ArithmeticException.class, () -> calculator.mult(a, b));
    }

}