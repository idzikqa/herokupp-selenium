package pl.idzikqa.herokuapp.pages;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pl.idzikqa.herokuapp.hooks.BasePage;

import java.io.IOException;

public class BasicAuthorizationPage extends BasePage {
    @FindBy(xpath = "//div[@class='example']//h3")
    WebElement headerSuccess;

    private String url = "https://the-internet.herokuapp.com/basic_auth";

    public BasicAuthorizationPage(WebDriver driver, ExtentTest extentTest) {
        super(driver, extentTest);
    }

    public void checkAuthorization() {
        try {
            Runtime.getRuntime().exec("c://developer//poligon-qa//herokupp-selenium//scripts//authentication.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.get(url);
    }


    public void onThePage() {
        Assert.assertTrue(driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/basic_auth"));
    }

}
