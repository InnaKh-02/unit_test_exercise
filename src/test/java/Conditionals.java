//import com.epam.tat.module4.Calculator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class Conditionals {
    static Calculator calculator;
    static boolean isFirstTime = true;

    @BeforeAll
    public static void preCond() {
        if (isFirstTime) {
            ScreenshotUtil.deleteScreenShots();
            isFirstTime = false;
        }
        calculator = new Calculator();
    }

    @AfterAll
    public static void postCond() {
        ScreenshotUtil.takeScreenshot();
    }
}
