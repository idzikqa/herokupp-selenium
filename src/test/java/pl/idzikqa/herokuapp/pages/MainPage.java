package pl.idzikqa.herokuapp.pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pl.idzikqa.herokuapp.hooks.BasePage;

import java.util.Map;

public class MainPage extends BasePage {

    @FindBy(xpath = "//div[@id='content']//h2")
    private WebElement headerInfo;

    private String url = "https://the-internet.herokuapp.com/drag_and_drop";
    private String onThePageText = "Available Examples";


    public MainPage(WebDriver driver, ExtentTest extentTest) {
        super(driver, extentTest);
    }

    public void onThePage() {
        Assert.assertTrue(headerInfo.getText().equals(onThePageText));
        test.log(LogStatus.INFO,"Main Page on the Page");
    }

    public void checkAllLinks() {
        Map<String, Integer> map = gm.checkLinks(gm.getClickableLinks());
        for (Map.Entry<String,Integer> entry:map.entrySet()
             ) {
            System.out.println("Link "+entry.getKey()+" , status: "+entry.getValue());
        }
    }

}
