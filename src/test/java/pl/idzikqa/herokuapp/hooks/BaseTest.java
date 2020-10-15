package pl.idzikqa.herokuapp.hooks;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pl.idzikqa.herokuapp.pages.*;
import pl.idzikqa.herokuapp.tools.ScreenShot;

import static pl.idzikqa.herokuapp.data.Configuration.site;

public abstract class BaseTest {
    private WebDriver driver;
    protected MainPage mainPage;
    protected AddRemoveElementsPage addRemoveElementsPage;
    protected DragAndDropPage dragAndDropPage;
    protected HoversPage hoversPage;
    protected FileUploadPage fileUploadPage;
    protected BasicAuthorizationPage basicAuthorizationPage;
    protected BrokenImages brokenImages;
    protected ChallengingDomPage challengingDomPage;

    protected ExtentReports reports;
    protected ExtentTest test;

    private String directory = "../screenshots/";

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
        reports = new ExtentReports("./reports/test.html", false);
        test = reports.startTest("TEST CASE");
        if (browser.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        } else {
            FirefoxOptions options = new FirefoxOptions();
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(options);
        }
        driver.manage().window().maximize();
        mainPage = new MainPage(driver, test);
        addRemoveElementsPage = new AddRemoveElementsPage(driver, test);
        dragAndDropPage = new DragAndDropPage(driver, test);
        hoversPage = new HoversPage(driver, test);
        fileUploadPage = new FileUploadPage(driver, test);
        basicAuthorizationPage = new BasicAuthorizationPage(driver, test);
        brokenImages=new BrokenImages(driver,test);
        challengingDomPage=new ChallengingDomPage(driver,test);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println("----- FAILED ----- " + testResult.getMethod().getMethodName());
            String pathToFile = ScreenShot.takeScreenShot(driver, directory);
            String imagePath = test.addScreenCapture(pathToFile);
            test.log(LogStatus.FAIL, "TEST FAILED", imagePath);

        }
        if (testResult.getStatus() == ITestResult.SUCCESS) {
            System.out.println("----- SUCCESS ----- " + testResult.getMethod().getMethodName());
        }
        reports.endTest(test);
        reports.flush();
        driver.close();
        driver.quit();
    }
}