package pl.idzikqa.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pl.idzikqa.herokuapp.hooks.BasePage;

import java.util.List;

public class AddRemoveElements extends BasePage {
    @FindBy(xpath = "//button[contains(string(),'Add Element')]")
    private WebElement buttonAddElement;

    @FindBy(xpath = "//div[@id='elements']//button[1]")
    private WebElement buttonDeleteElement;

    @FindBy(xpath = "//button[contains(string(),'Delete')]")
    private List<WebElement> elements;

    @FindBy(xpath = "//div[@id='content']//h3")
    private WebElement headerInfo;

    public AddRemoveElements(WebDriver driver) {
        super(driver);
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
    }

    private void clickAddButton() {
        buttonAddElement.click();
    }

    public void addElement(int previousSize) {
        gm.clickElementWithSizeAssertion(buttonAddElement, elements, previousSize + 1);
    }

    public void addElements(int number) {
        for (int i = 0; i < number; i++) {
            this.addElement(i);
        }
    }

    public void deleteElement(int previousSize) {
        gm.clickElementWithSizeAssertion(buttonDeleteElement, elements, previousSize);
    }

    public void deleteElements(int number) {
        for (int i = 1; i < number + 1; i++) {
            this.deleteElement(number - i);
        }
    }

    public boolean onThePage() {
        return headerInfo.getText().contains("Add/Remove Elements");
    }
}
