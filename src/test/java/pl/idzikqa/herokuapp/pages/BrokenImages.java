package pl.idzikqa.herokuapp.pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pl.idzikqa.herokuapp.hooks.BasePage;

import java.util.List;

public class BrokenImages extends BasePage {
    @FindBy(xpath = "//h3[contains(string(),'Broken Images')]//following-sibling::img")
    List<WebElement> images;

    @FindBy(xpath = "//div[@class='example']//h3")
    private WebElement headerInfo;

    private String url = "https://the-internet.herokuapp.com/broken_images";
    private String onPageText = "Broken Images";

    public BrokenImages(WebDriver driver, ExtentTest extentTest) {
        super(driver, extentTest);
    }

    public void onThePage() {
        driver.get(url);
        Assert.assertTrue(gm.doesElementContainsText(headerInfo, onPageText));
        test.log(LogStatus.INFO, "Broken Images on the Page");
    }

    public void checkAllImages() {
        List<String> list = gm.findBrokenImages(images);
        System.out.println("Broken images");
        list.forEach(img -> test.log(LogStatus.INFO, "Image " + img + " is broken"));
    }
}
