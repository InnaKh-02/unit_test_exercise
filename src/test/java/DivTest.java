import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DivTest extends Conditionals {
    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @CsvSource({"4, 4, 1", "-6, -3, 2"})
    public void testDivOfLongs(long a, long b, long exp) {
        assertEquals(exp, calculator.div(a, b));
    }

    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @CsvSource({"4.4, 2.0, 2.2", "-4.8, -2.4, 2.0"})
    public void testDivOfDoubles(double a, double b, double exp) {
        assertEquals(exp, calculator.div(a, b));
    }

    @Execution(ExecutionMode.CONCURRENT)
    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.div(-10, 0));
        assertThrows(ArithmeticException.class, () -> calculator.div(1.0, 0.0));
    }

    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @ValueSource(doubles = {Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY})
    void testDivInvalidInputs(double invalid) {
        assertThrows(IllegalArgumentException.class, () -> calculator.div(invalid, 10));
    }
}