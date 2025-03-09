import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CosTest extends Conditionals
{
    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @CsvSource({"0.0, 1.0", "3.1416, -1.0", "1.5708, 0.0", "4.7124, 0.0"})
    public void testCosOfDoubles(double a, double exp){
        assertEquals(exp, calculator.cos(a), 0.0001);
    }

    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @ValueSource(doubles = {Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY})
    public void testCosInvalidInputs(double invalid) {
        assertThrows(IllegalArgumentException.class, () -> calculator.cos(invalid));
    }
}