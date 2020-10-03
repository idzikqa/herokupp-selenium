package pl.idzikqa.herokuapp.hooks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pl.idzikqa.herokuapp.pages.AddRemoveElementsPage;
import pl.idzikqa.herokuapp.pages.MainPage;
import pl.idzikqa.herokuapp.pages.DragAndDropPage;
import pl.idzikqa.herokuapp.pages.HoversPage;

import static pl.idzikqa.herokuapp.data.Configuration.site;

public abstract class BaseTest {
    private WebDriver driver;
    protected MainPage mainPage;
    protected AddRemoveElementsPage addRemoveElementsPage;
    protected DragAndDropPage dragAndDropPage;
    protected HoversPage hoversPage;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(site);
        mainPage =new MainPage(driver);
        addRemoveElementsPage = new AddRemoveElementsPage(driver);
        dragAndDropPage = new DragAndDropPage(driver);
        hoversPage=new HoversPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}