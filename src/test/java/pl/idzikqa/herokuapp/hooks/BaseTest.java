package pl.idzikqa.herokuapp.hooks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;
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

//    @BeforeClass
//    public void beforeClass() {
//        System.out.println("Before class");
//    }
//
//    @AfterClass
//    public void afterClass() {
//        System.out.println("After class");
//    }
//
//    @BeforeSuite
//    public void beforeSuite() {
//        System.out.println("Before suite");
//    }
//
//    @AfterSuite
//    public void afterSuite() {
//        System.out.println("After suite");
//    }
//
//    @BeforeTest
//    public void beforeTest() {
//        System.out.println("Before test in suite");
//    }
//
//    @AfterTest
//    public void afterTest(){
//        System.out.println("After test in suite");
//    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void setup(@Optional("chrome") String browser) {
        if (browser.equals("chrome")){
            ChromeOptions options = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        else {
            FirefoxOptions options = new FirefoxOptions();
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
        }

        driver.get(site);
        mainPage = new MainPage(driver);
        addRemoveElementsPage = new AddRemoveElementsPage(driver);
        dragAndDropPage = new DragAndDropPage(driver);
        hoversPage = new HoversPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}