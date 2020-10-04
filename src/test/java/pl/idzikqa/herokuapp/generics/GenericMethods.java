package pl.idzikqa.herokuapp.generics;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.concurrent.TimeUnit.*;

public class GenericMethods {
    private WebDriver driver;
    private JavascriptExecutor js;

    public GenericMethods(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
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

    public boolean doesElementContainsText(WebElement webElement, String text) {
        return webElement.getText().contains(text);
    }

    private static String readFile(String file) throws IOException {
        Charset cs = Charset.forName("UTF-8");
        FileInputStream stream = new FileInputStream(file);
        try {
            Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[8192];
            int read;
            while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
                builder.append(buffer, 0, read);
            }
            return builder.toString();
        } finally {
            stream.close();
        }
    }

    public void dragAndDropHTML5(String source, String target, WebElement fromHeader, WebElement toHeader) {
        String fromText = fromHeader.getText();
        String toText = toHeader.getText();
        try {
            String basePath = new File("").getAbsolutePath();
            final String JQUERY_LOAD_SCRIPT = (basePath + "/src/test/resources/jquery_load_helper.js");
            String jQueryLoader = readFile(JQUERY_LOAD_SCRIPT);

            driver.manage().timeouts().setScriptTimeout(10, SECONDS);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeAsyncScript(jQueryLoader);

            js.executeScript("jQuery(function($) { " + " $('input[name=\"q\"]').val('bada-bing').closest('form').submit(); "
                    + " }); ");

            String filePath = basePath + "/src/test/resources/drag_and_drop_helper.js";

            StringBuffer buffer = new StringBuffer();
            String line;
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null)
                buffer.append(line);

            String javaScript = buffer.toString();

            javaScript = javaScript + "$('" + source + "').simulateDragDrop({ dropTarget: '" + target + "'});";
            ((JavascriptExecutor) driver).executeScript(javaScript);
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertTrue(fromHeader.getText().equals(toText));
        Assert.assertTrue(toHeader.getText().equals(fromText));
    }


    public void dragAndDropByHeader(WebElement fromElement, WebElement fromHeader, WebElement toElement, WebElement toHeader) {

        Actions actions = new Actions(driver);
        actions.clickAndHold(fromElement).moveToElement(toElement).release().perform();

        Assert.assertTrue(fromHeader.getText().contains(toHeader.getText()));
        Assert.assertTrue(toHeader.getText().contains(fromHeader.getText()));
    }

    private void hoverOverTheElementWithTextAssertion(WebElement webElement, By locator, String text) {
        if (isElementDisplayed(webElement)) {
            Actions action = new Actions(driver);
            action.moveToElement(webElement).perform();
            WebElement resultElement = webElement.findElement((locator));
            if (isElementDisplayed(resultElement)) {
                Assert.assertTrue(resultElement.getText().equals(text));
            }
        }
    }

    public void hoverOverTheElementsWithTextAssertion(List<WebElement> elementList, By locator, String text) {
        for (WebElement webElement : elementList
        ) {
            hoverOverTheElementWithTextAssertion(webElement, locator, text);
        }
        Reporter.log("raport z hovera");
    }


    public int linkStatus(URL url) {
        try {
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.connect();
            int respone = http.getResponseCode();
            http.disconnect();
            return respone;
        } catch (IOException e) {
            return -1;
        }
    }

    public List<WebElement> getClickableLinks() {
        List<WebElement> links = new ArrayList<>();
        links.addAll(driver.findElements(By.tagName("a")));
        links.addAll(driver.findElements(By.tagName("img")));
        return links.stream().filter(element -> element.getAttribute("href") != null).collect(Collectors.toList());
    }

    public Map<String, Integer> checkLinks(List<WebElement> list) {
        Map<String, Integer> map = new HashMap<>();
        for (WebElement element : list
        ) {
            String href = element.getAttribute("href");
            try {
                map.put(href, linkStatus(new URL(href)));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

}
