import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class NegativeNumTest extends Conditionals
{
    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @CsvSource({"1, false", "-5, true"})
    public void testNegOfNum(long a, boolean exp){
        assertEquals(exp, calculator.isNegative(a));
    }
    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @ValueSource(longs = {10L, -10L, 0L, Long.MAX_VALUE, Long.MIN_VALUE})
    void testInvalidLongInputNeg(long invalidLong) {
        assertThrows(ClassCastException.class, () -> calculator.isNegative(invalidLong));
    }
}
