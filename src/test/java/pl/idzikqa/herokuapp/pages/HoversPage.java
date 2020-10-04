package pl.idzikqa.herokuapp.pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pl.idzikqa.herokuapp.hooks.BasePage;

import java.util.List;

public class HoversPage extends BasePage {
    @FindBy(xpath = "//div[@class='figure']")
    private List<WebElement> links;

    @FindBy(xpath = "//div[@class='example']//h3")
    private WebElement headerInfo;

    private String url = "https://the-internet.herokuapp.com/hovers";
    private String onPageText = "Hovers";
    private String assertText = "View profile";
    private String assertSelector = "div//a";

    protected static final Logger log= LogManager.getLogger(HoversPage.class.getName());

    public HoversPage(WebDriver driver, ExtentTest extentTest) {
        super(driver,extentTest);
    }

    public void onThePage() {
        driver.get(url);
        log.debug("on The Page");
        Assert.assertTrue(gm.doesElementContainsText(headerInfo, onPageText));
        test.log(LogStatus.INFO,"Hovers on the Page");
    }

    public void hoverToElements() {
        gm.hoverOverTheElementsWithTextAssertion(links, By.xpath(assertSelector), assertText);
    }

}
