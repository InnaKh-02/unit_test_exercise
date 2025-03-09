import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class TgTest extends Conditionals
{
    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @CsvSource({"1.047, 1.732", "0.524, 0.577"})
    public void testTgOfDoubles(double a, double exp){
        assertEquals(exp, calculator.tg(a), 0.001);
    }

    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @ValueSource(doubles = {Math.PI / 2, (3 * Math.PI) / 2})
    void testTgUndefined(double angle) {
        assertThrows(ArithmeticException.class, () -> calculator.tg(angle));
    }

    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @ValueSource(doubles = {Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY})
    public void testTgInvalidInputs(double invalid) {
        assertThrows(IllegalArgumentException.class, () -> calculator.tg(invalid));
    }
}