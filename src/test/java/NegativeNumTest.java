import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class NegativeNumTest extends Conditionals {
    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @CsvSource({"1, false", "-5, true", "0, false", "100, false", "-100, true", "-9223372036854775808, true"})
    public void testNegOfNum(long a, boolean exp) {
        assertEquals(exp, calculator.isNegative(a));
    }

    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @ValueSource(strings = {"9223372036854775808", "-9223372036854775809", "notANumber", "", " "})
    void testInvalidLongInputNeg(String invalidLong) {
        assertThrows(NumberFormatException.class, () -> {
            long parsedValue = Long.parseLong(invalidLong);
            calculator.isNegative(parsedValue);
        });
    }
}
