package utilities;

import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Page;
import java.nio.file.Paths;

public class ScreenshotUtility {

    // Optional method to capture screenshots on failure
    public static void captureScreenshot(Page page, ExtentTest test) {
        try {
            // Create the path for the screenshot
            String screenshotPath = "test-output/images/failure_" + System.currentTimeMillis() + ".png";

            // Capture the screenshot
            page.screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get(screenshotPath)));

            // Add screenshot to ExtentReport
            test.addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
