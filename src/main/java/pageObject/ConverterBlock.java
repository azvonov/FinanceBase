package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import util.CurrencyType;

/**
 * Created with IntelliJ IDEA.
 * User: gam
 * Date: 10.12.13
 * Time: 1:29
 * To change this template use File | Settings | File Templates.
 */
public class ConverterBlock {

    private final WebDriver driver;

    @FindBy(id = "fn_s1")
    private WebElement amount;

    @FindBy(id="fn_c1")
    private WebElement currency;

    @FindBy(id = "fn_o1_1")
    private WebElement resultUah;

    @FindBy(id = "fn_o1_978")
    private WebElement resultRub;

    @FindBy(id = "fn_o1_643")
    private WebElement resultEur;

    @FindBy(id="fn_bank")
    private WebElement exchangeRate;

    public ConverterBlock(WebDriver driver) {
        this.driver = driver;
    }

    public ConverterBlock setAmount(String value){
        amount.sendKeys(value);
        return  this;
    }
    public ConverterBlock setCurrency (CurrencyType currencyType){
        getSelect(currency).selectByVisibleText(currencyType.getText());
        return this;
    }
    public ConverterBlock setExchangeRate (String rate) {
        getSelect(exchangeRate).selectByVisibleText(rate);
        return this;
    }

    public Select getSelect(WebElement webElement) {
        return new Select(webElement);
    }

    public String getResultUah(){
        return resultUah.getAttribute("value");
    }

}
