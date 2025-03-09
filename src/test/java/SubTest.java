import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SubTest extends Conditionals
{
    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @CsvSource({"1, 4, -3", "-5, -3, -2"})
    public void testSubOfLongs(long a, long b, long exp){
        assertEquals(exp, calculator.sub(a, b));
    }

    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @CsvSource({"1.0, 4.5, -3.5", "-4.8, -3.0, -1.8"})
    public void testSubOfDoubles(double a, double b, double exp){
        assertEquals(exp, calculator.sub(a, b), Math.pow(10, -15));
    }
    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @ValueSource(doubles = {Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY})
    void testSubInvalidInputs(double invalid) {
        assertThrows(IllegalArgumentException.class, () -> calculator.sub(invalid, 10));
    }
}