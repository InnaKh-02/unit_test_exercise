import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PositiveNumTest extends Conditionals
{
    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @CsvSource({"1, true", "-5, false"})
    public void testPosOfNum(long a, boolean exp){
        assertEquals(exp, calculator.isPositive(a));
    }
    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @ValueSource(longs = {10L, -10L, 0L, Long.MAX_VALUE, Long.MIN_VALUE})
    void testInvalidLongInputPos(long invalidLong) {
        assertThrows(ClassCastException.class, () -> calculator.isPositive(invalidLong));
    }
}