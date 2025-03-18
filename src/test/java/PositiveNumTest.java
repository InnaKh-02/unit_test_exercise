import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PositiveNumTest extends Conditionals {
    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @CsvSource({"1, true", "-5, false", "0, false", "100, true", "-100, false", "9223372036854775807, true"})
    public void testPosOfNum(long a, boolean exp) {
        assertEquals(exp, calculator.isPositive(a));
    }

    @ParameterizedTest
    @ValueSource(strings = {"9223372036854775808", "-9223372036854775809", "notANumber", "", " "})
    void testInvalidLongInputPos(String invalidLong) {
        assertThrows(NumberFormatException.class, () -> {
            long parsedValue = Long.parseLong(invalidLong);
            calculator.isPositive(parsedValue);
        });
    }
}