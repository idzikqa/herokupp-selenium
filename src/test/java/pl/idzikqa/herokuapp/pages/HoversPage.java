package pl.idzikqa.herokuapp.pages;

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

    public HoversPage(WebDriver driver) {
        super(driver);
    }

    public void onThePage() {
        driver.get(url);
        Assert.assertTrue(gm.doesElementContainsText(headerInfo, onPageText));
    }

    public void hoverToElements() {
        gm.hoverOverTheElementsWithTextAssertion(links, By.xpath(assertSelector), assertText);
    }

}
