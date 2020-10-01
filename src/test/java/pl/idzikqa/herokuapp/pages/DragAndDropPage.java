package pl.idzikqa.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pl.idzikqa.herokuapp.hooks.BasePage;

public class DragAndDropPage extends BasePage {

    @FindBy(xpath = "//div[@id='columns']//div[1]//header")
    private WebElement fromHeader;

    @FindBy(xpath = "//div[@id='columns']//div[2]//header")
    private WebElement toHeader;

    @FindBy(xpath = "//div[@class='example']//h3")
    private WebElement headerInfo;

    private String url = "https://the-internet.herokuapp.com/drag_and_drop";
    private String onPageText = "Drag and Drop";
    private String fromElement = "#column-a";
    private String toElement = "#column-b";

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public void onThePage() {
        driver.get(url);
        Assert.assertTrue(gm.doesElementContainsText(headerInfo, onPageText));
    }

    public void dragAndDropHTML5() {
        gm.dragAndDropHTML5(fromElement, toElement, fromHeader, toHeader);
    }


}
