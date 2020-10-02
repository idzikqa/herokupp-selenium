package pl.idzikqa.herokuapp.testcases;

import org.testng.annotations.Test;
import pl.idzikqa.herokuapp.hooks.BaseTest;

public class MainPageTest extends BaseTest {

    @Test
    public void checkAllLinks() {

        mainPage.onThePage();
        mainPage.checkAllLinks();

    }
}
