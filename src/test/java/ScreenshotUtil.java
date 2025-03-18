import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ScreenshotUtil {
    public static void deleteScreenShots() {
        File folder = new File("screenshots");
        if (folder.exists() && folder.isDirectory()) {
            for (File file : folder.listFiles()) {
                file.delete();
            }
        }
    }

    public static void takeScreenshot() {
        try {
            Thread.sleep(500);
            Robot robot = new Robot();
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
            File file = new File("screenshots/screenshot_" + System.currentTimeMillis() + ".png");
            ImageIO.write(screenFullImage, "png", file);
            System.out.println("screenshot saved at " + file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
