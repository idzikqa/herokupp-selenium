package pl.idzikqa.herokuapp.testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pl.idzikqa.herokuapp.hooks.BaseTest;
import pl.idzikqa.herokuapp.listeners.MyListener;

@Listeners(value = MyListener.class)
public class HoversTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void HoverTest(){

        hoversPage.onThePage();
        hoversPage.hoverToElements();

    }
}
