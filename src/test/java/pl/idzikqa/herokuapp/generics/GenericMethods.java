package pl.idzikqa.herokuapp.generics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class GenericMethods {
    private WebDriver driver;

    public GenericMethods(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(String type, String locator) {
        switch (type.toLowerCase()) {
            case "id":
                return this.driver.findElement(By.id(locator));
            case "name":
                return this.driver.findElement(By.name(locator));
            case "xpath":
                return this.driver.findElement(By.xpath(locator));
            case "css":
                return this.driver.findElement(By.cssSelector(locator));
            case "link":
                return this.driver.findElement(By.linkText(locator));
            case "partial":
                return this.driver.findElement(By.partialLinkText(locator));
            case "class":
                return this.driver.findElement(By.className(locator));
            default:
                return this.driver.findElement(By.tagName(locator));
        }
    }

    public List<WebElement> getElementList(String type, String locator) {
        switch (type.toLowerCase()) {
            case "id":
                return this.driver.findElements(By.id(locator));
            case "name":
                return this.driver.findElements(By.name(locator));
            case "xpath":
                return this.driver.findElements(By.xpath(locator));
            case "css":
                return this.driver.findElements(By.cssSelector(locator));
            case "link":
                return this.driver.findElements(By.linkText(locator));
            case "partial":
                return this.driver.findElements(By.partialLinkText(locator));
            case "class":
                return this.driver.findElements(By.className(locator));
            default:
                return this.driver.findElements(By.tagName(locator));
        }
    }

    public boolean isElementPresent(String type, String locator) {
        List<WebElement> elements = getElementList(type, locator);
        return elements.size() == 1;
    }

    public void clickElementWithTextAssertion(WebElement webElement, WebElement resultElement, String assertion) {
        Assert.assertTrue(isElementClickable(webElement));
    }

    public void clickElementWithSizeAssertion(WebElement webElement, List<WebElement> webElements, int size) {
        if (isElementClickable(webElement)) {
            webElement.click();
            Assert.assertTrue(webElements.size() == size);
        }
    }

    public void clickElementAndWaitForSizeAssertion(WebElement webElement, By parent, By children, int size) {
        if (isElementClickable(webElement)) {
            webElement.click();
            WebElement assertElement = waitForElement(parent, 3);
            Assert.assertTrue(assertElement.findElements(children).size() == size);
        }
    }

    private boolean isElementDisplayed(WebElement webElement) {
        return webElement.isDisplayed();
    }

    private boolean isElementEnabled(WebElement webElement) {
        return webElement.isEnabled();
    }

    private boolean isElementClickable(WebElement webElement) {
        return isElementDisplayed(webElement) && isElementEnabled(webElement);
    }

    public WebElement waitForElement(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(this.driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement clickWhenReady(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(this.driver, timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
