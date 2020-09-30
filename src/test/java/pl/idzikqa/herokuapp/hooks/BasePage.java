package pl.idzikqa.herokuapp.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pl.idzikqa.herokuapp.generics.GenericMethods;

public abstract class BasePage {
    protected WebDriver driver;
    protected GenericMethods gm;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.gm=new GenericMethods(driver);
        PageFactory.initElements(driver,this);
    }
}
