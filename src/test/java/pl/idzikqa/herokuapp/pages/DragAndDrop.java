package pl.idzikqa.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pl.idzikqa.herokuapp.hooks.BasePage;

public class DragAndDrop extends BasePage {

    @FindBy(xpath = "//div[@id='columns']//div[1]//header")
    private WebElement fromHeader;

    @FindBy(xpath = "//div[@id='columns']//div[2]//header")
    private WebElement toHeader;

    @FindBy(xpath = "//div[@class='example']//h3")
    private WebElement headerInfo;

    public DragAndDrop(WebDriver driver) {
        super(driver);
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
    }

    public boolean onThePage() {
        return gm.doesElementContainsText(headerInfo, "Drag and Drop");
    }

    public void dragAndDropHTML5() {
        gm.dragAndDropHTML5("#column-a", "#column-b",fromHeader, toHeader);
    }


}
