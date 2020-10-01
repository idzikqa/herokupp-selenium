package pl.idzikqa.herokuapp.hooks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pl.idzikqa.herokuapp.pages.AddRemoveElements;
import pl.idzikqa.herokuapp.pages.DragAndDrop;

import static pl.idzikqa.herokuapp.data.Configuration.site;

public abstract class BaseTest {
    private WebDriver driver;
    protected AddRemoveElements addRemoveElements;
    protected DragAndDrop dragAndDrop;


    @BeforeTest
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(site);
        addRemoveElements = new AddRemoveElements(driver);
        dragAndDrop = new DragAndDrop(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}