package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: gam
 * Date: 16.12.13
 * Time: 0:06
 * To change this template use File | Settings | File Templates.
 */
public class FuelPage {

    private final WebDriver driver;

    @FindBy(xpath = "//div[@id='feMain2']/table")
    private WebElement grid;

    public FuelPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getAllRows(){
       return grid.findElements(By.tagName("tr"));
    }
}
