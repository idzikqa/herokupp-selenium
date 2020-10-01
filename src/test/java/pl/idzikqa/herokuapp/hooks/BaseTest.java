package pl.idzikqa.herokuapp.hooks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pl.idzikqa.herokuapp.pages.AddRemoveElementsPage;
import pl.idzikqa.herokuapp.pages.DragAndDropPage;
import pl.idzikqa.herokuapp.pages.HoversPage;

import static pl.idzikqa.herokuapp.data.Configuration.site;

public abstract class BaseTest {
    private WebDriver driver;
    protected AddRemoveElementsPage addRemoveElementsPage;
    protected DragAndDropPage dragAndDropPage;
    protected HoversPage hoversPage;

    @BeforeTest
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(site);
        addRemoveElementsPage = new AddRemoveElementsPage(driver);
        dragAndDropPage = new DragAndDropPage(driver);
        hoversPage=new HoversPage(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}