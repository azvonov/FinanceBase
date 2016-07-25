package webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import util.Browser;

import java.io.File;
import java.io.IOException;

public class WebDriverFactory {

    public static WebDriver getInstance(Browser browser) throws IOException {

        WebDriver webDriver = null;

        switch (browser) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
                webDriver = new ChromeDriver();
                break;
            case FIREFOX:
                FirefoxProfile ffProfile = new FirefoxProfile();
              //  ffProfile.addExtension(new File("firebug-1.11.4.xpi"));
                webDriver = new FirefoxDriver(ffProfile);
                break;
            case HTML_UNIT:
                webDriver = new HtmlUnitDriver();
                break;
        }
        return webDriver;
    }
}