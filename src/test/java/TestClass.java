import Entity.ExchangeRateEntity;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.HomePage;
import util.CurrencyType;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestClass extends BaseTest {

    HomePage homePage;

    @BeforeClass
    public void setUp() {
        log.info("setUp");
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
    }

    @Test(groups = "regression")
    public void testConverterAverageSell() {
        String expectedResult = "13 664,27";
        homePage.sellCurrency("500", CurrencyType.EUR, "НБУ");
        String uahResult = homePage.getConverterBlock().getResultUah();
        log.info( StringUtils.difference(uahResult,expectedResult));
        Assert.assertEquals(uahResult, expectedResult);
        log.info("test Passed");
    }

    @Test
    public void testBidRate() {
        String expectedBid = "24.9500";

        String bidRate = homePage.getExchangeRatesBlock()
                .getBidRate("Universal Bank");
        Assert.assertEquals(bidRate, expectedBid);
    }

    @Test
    public void testExchangeRates() {
        ExchangeRateEntity expectedEntity
                = new ExchangeRateEntity("OTPBank"
                , "8.2600"
                , "8.2900");

        ExchangeRateEntity actualEntity = homePage.getExchangeRatesBlock()
                .getExchangeRates("OTPBank");
        Assert.assertTrue(actualEntity.equals(expectedEntity));
    }

    @Test
    public void testScreenShot() throws IOException {
        takeScreenshot();
    }

    @Test
    public void testExplicitWait() {
        driver.manage().timeouts().implicitlyWait(0L, TimeUnit.SECONDS);
        homePage.clickFuelLink();
        driver.findElement(By.partialLinkText("ТНК"));
        Wait wait = new FluentWait(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS);

        wait.until(ExpectedConditions.textToBePresentInElement(
                By.partialLinkText("WOG"), "WOG"));
    }


}
