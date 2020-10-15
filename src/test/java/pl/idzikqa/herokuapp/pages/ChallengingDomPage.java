package pl.idzikqa.herokuapp.pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pl.idzikqa.herokuapp.hooks.BasePage;

import java.util.List;

public class ChallengingDomPage extends BasePage {
    @FindBy(css = "#content table")
    private WebElement table;

    @FindBy(xpath = "//a[@class='button']")
    private WebElement button;

    @FindBy(xpath = "//a[@class='button alert']")
    private WebElement buttonAlert;

    @FindBy(xpath = "//a[@class='button success']")
    private WebElement buttonSuccess;

    @FindBy(xpath = "//div[@class='example']//h3")
    private WebElement headerInfo;

    private String url = "https://the-internet.herokuapp.com/challenging_dom";
    private String onPageText = "Challenging DOM";

    public ChallengingDomPage(WebDriver driver, ExtentTest extentTest) {
        super(driver, extentTest);
    }

    public void onThePage() {
        driver.get(url);
        Assert.assertTrue(gm.doesElementContainsText(headerInfo, onPageText));
        test.log(LogStatus.INFO, "Challenging Dom on the Page");
    }

    public void readTable() {
        List<List<String>> tableList = gm.readHTMLTableExcludeTh(table);
        for (List<String> row : tableList
        ) {
            System.out.println(row);
        }
    }

    public void clickButtonsWork() {
        gm.clickButtonAndCheckCanvas(button);
        gm.clickButtonAndCheckCanvas(buttonAlert);
        gm.clickButtonAndCheckCanvas(buttonSuccess);

    }

}
