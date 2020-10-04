package pl.idzikqa.herokuapp.pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pl.idzikqa.herokuapp.hooks.BasePage;

import java.util.List;

public class AddRemoveElementsPage extends BasePage {
    @FindBy(xpath = "//button[contains(string(),'Add Element')]")
    private WebElement buttonAddElement;

    @FindBy(xpath = "//div[@id='elements']//button[1]")
    private WebElement buttonDeleteElement;

    @FindBy(xpath = "//button[contains(string(),'Delete')]")
    private List<WebElement> elements;

    @FindBy(xpath = "//div[@id='content']//h3")
    private WebElement headerInfo;

    private String url="https://the-internet.herokuapp.com/add_remove_elements/";
    private String onPageText="Add/Remove Elements";

    public AddRemoveElementsPage(WebDriver driver, ExtentTest extentTest) {
        super(driver,extentTest);
    }

    public void onThePage() {
        driver.get(url);
        Assert.assertTrue(gm.doesElementContainsText(headerInfo,onPageText));
        test.log(LogStatus.INFO,"Add/Remove Elements on the Page");
    }

    public void addElements(int number) {
        for (int i = 0; i < number; i++) {
            this.addElement(i);
        }
    }

    public void deleteElements(int number) {
        for (int i = 1; i < number + 1; i++) {
            this.deleteElement(number - i);
        }
    }

    private void addElement(int previousSize) {
        gm.clickElementWithSizeAssertion(buttonAddElement, elements, previousSize + 1);
    }

    private void deleteElement(int previousSize) {
        gm.clickElementWithSizeAssertion(buttonDeleteElement, elements, previousSize);
    }

}