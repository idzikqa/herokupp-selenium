package pl.idzikqa.herokuapp.testcases;

import org.testng.annotations.Test;
import pl.idzikqa.herokuapp.hooks.BaseTest;

public class HoversTest extends BaseTest {
    @Test(groups = {"smoke"})
    public void HoverTest(){

        hoversPage.onThePage();
        hoversPage.hoverToElements();

    }
}
