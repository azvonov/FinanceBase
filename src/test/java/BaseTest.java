import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import util.Browser;
import util.PropertyLoader;
import webDriver.WebDriverFactory;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * User: gam
 * Date: 10.12.13
 * Time: 1:12
 */
public class BaseTest {

    protected WebDriver driver;
    protected static org.apache.log4j.Logger log = Logger
            .getLogger(BaseTest.class);

    private final String SCREENSHOT_FOLDER = PropertyLoader.loadProperty("screenshot.folder");
    private final String SCREENSHOT_FORMAT = PropertyLoader.loadProperty("screenshot.format");

    @BeforeSuite
    public void init() throws IOException {
        log.info("BeforeSuite");
        driver = WebDriverFactory.getInstance(Browser.FIREFOX);
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void tearDown() {
        log.info("TearDown");
        driver.quit();
    }

    protected void takeScreenshot() throws IOException {
        log.info("Taking Screen Shot");
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(SCREENSHOT_FOLDER + getScreenShotName() + SCREENSHOT_FORMAT));
    }

    private String getScreenShotName() {
        return Calendar.getInstance().getTime()
                .toString().replaceAll(" ", "")
                .replaceAll(":", "");
    }
}
