package pl.idzikqa.herokuapp.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.idzikqa.herokuapp.generics.GenericMethods;

public abstract class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;
    protected GenericMethods gm;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait=new WebDriverWait(driver,20);
        this.gm=new GenericMethods(driver);
        PageFactory.initElements(driver,this);
    }
}
