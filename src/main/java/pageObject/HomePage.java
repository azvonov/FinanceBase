package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.CurrencyType;
import util.PropertyLoader;

/**
 * User: gam
 * Date: 10.12.13
 * Time: 0:46
 */
public class HomePage {

    private final String URL = PropertyLoader.loadProperty("site.url");
    private final WebDriver driver;

    @FindBy(partialLinkText = "Топливо")
    private WebElement fuelLink;

    private ConverterBlock converterBlock;
    private ExchangeRatesBlock exchangeRatesBlock;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        converterBlock = PageFactory.initElements(driver, ConverterBlock.class);
        exchangeRatesBlock = PageFactory.initElements(driver, ExchangeRatesBlock.class);
    }

    public HomePage open() {
        driver.get(URL);
        return this;
    }

    public FuelPage clickFuelLink(){
      fuelLink.click();
      return PageFactory.initElements(driver,FuelPage.class);
    }

    public HomePage sellCurrency(String amount, CurrencyType currency, String rateBy){
        converterBlock.setAmount(amount)
                .setCurrency(currency)
                .setExchangeRate(rateBy);
        return this;
    }

    public ConverterBlock getConverterBlock() {
        return converterBlock;
    }

    public ExchangeRatesBlock getExchangeRatesBlock() {
        return exchangeRatesBlock;
    }
}
