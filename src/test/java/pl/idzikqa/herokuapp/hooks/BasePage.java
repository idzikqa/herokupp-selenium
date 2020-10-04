package pl.idzikqa.herokuapp.hooks;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pl.idzikqa.herokuapp.generics.GenericMethods;

public abstract class BasePage {
    protected WebDriver driver;
    protected JavascriptExecutor js;
    protected GenericMethods gm;
    protected ExtentTest test;

    public BasePage(WebDriver driver, ExtentTest extentTest) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        this.gm = new GenericMethods(driver);
        this.test=extentTest;
        PageFactory.initElements(driver, this);
    }
}
