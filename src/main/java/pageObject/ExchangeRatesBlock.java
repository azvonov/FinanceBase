package pageObject;

import Entity.ExchangeRateEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ExchangeRatesBlock {

    private final WebDriver driver;

    @FindBy(xpath = "//div[@id='feMain2']/table")
    private WebElement grid;

    public ExchangeRatesBlock(WebDriver driver) {
        this.driver = driver;
    }

    public String getBidRate(String bankName) {
        List<WebElement> allRows = grid.findElements(By.tagName("tr"));
        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.size() <= 0) {
                continue;
            }
            if (cells.get(0).getText().equals(bankName)) {
                return cells.get(2).getText();
            }
        }
        return null;
    }

    public ExchangeRateEntity getExchangeRates(String bankName) {
        ExchangeRateEntity entity = new ExchangeRateEntity();

        List<WebElement> allRows = grid.findElements(By.tagName("tr"));
        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.size() <= 0) {
                continue;
            }
            if (cells.get(0).getText().equals(bankName)) {
                entity.setBankName(bankName);
                entity.setAsk(cells.get(1).getText());
                entity.setBid(cells.get(2).getText());
                return entity;
            }
        }
        return null;

    }
}
