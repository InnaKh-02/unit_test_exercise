import com.epam.tat.module4.Timeout;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class TimeoutTest {
    @AfterAll
    public static void postCond(){
        System.out.println("test ' ' -  complete");
        ScreenshotUtil.takeScreenshot();
    }
    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testSleep(int sec) {
        long startTime = System.currentTimeMillis();
        Timeout.sleep(sec);
        long elapsedTime = System.currentTimeMillis() - startTime;
        assertTrue(elapsedTime >= sec * 1000 && elapsedTime <= sec * 1100);
    }
    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest
    @ValueSource(ints = {0, -5})
    public void testSleepZeroAndLess(int value) {
        if (value < 0) {
            assertThrows(IllegalArgumentException.class, () -> Timeout.sleep(value));
        } else {
            long start = System.currentTimeMillis();
            Timeout.sleep(value);
            long end = System.currentTimeMillis();
            assertTrue((end - start) < 10);
        }
    }
    @Execution(ExecutionMode.CONCURRENT)
    @Test
    void testSleepMaxInt() {
        assertThrows(IllegalArgumentException.class, () -> Timeout.sleep(Integer.MAX_VALUE / 1000 + 1));
    }
    @Execution(ExecutionMode.CONCURRENT)
    @Test
    void testSleepInterrupted() throws InterruptedException {
        Thread thread = new Thread(() -> Timeout.sleep(5));
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
        thread.join(200);
        assertFalse(thread.isAlive());
    }
}
