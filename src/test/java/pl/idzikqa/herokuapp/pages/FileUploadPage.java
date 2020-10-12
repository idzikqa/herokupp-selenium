package pl.idzikqa.herokuapp.pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pl.idzikqa.herokuapp.hooks.BasePage;
import pl.idzikqa.herokuapp.tools.RobotMethods;

import java.awt.datatransfer.StringSelection;

public class FileUploadPage extends BasePage {
    @FindBy(xpath = "//div[@class='example']//h3")
    private WebElement headerInfo;

    @FindBy(id = "file-upload")
    private WebElement inputFileUpload;

    @FindBy(id = "file-submit")
    private WebElement buttonSubmit;

    private String url = "https://the-internet.herokuapp.com/upload";
    private String onPageText = "File Uploader";
    private String assertText = "File Uploaded!";

    public FileUploadPage(WebDriver driver, ExtentTest extentTest) {
        super(driver, extentTest);
    }

    public void onThePage() {
        driver.get(url);
        Assert.assertTrue(gm.doesElementContainsText(headerInfo, onPageText));
        test.log(LogStatus.INFO, "File Upload Page");
    }

    public void fileUpload(String file) {
        inputFileUpload.sendKeys(file);
        gm.clickElementWithTextAssertion(buttonSubmit, headerInfo, assertText);
    }
}
