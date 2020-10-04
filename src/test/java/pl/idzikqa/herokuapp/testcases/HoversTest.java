package pl.idzikqa.herokuapp.testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pl.idzikqa.herokuapp.hooks.BaseTest;
import pl.idzikqa.herokuapp.listeners.MyInvokeMethodListener;
import pl.idzikqa.herokuapp.listeners.MyTestListener;

@Listeners(value = {MyInvokeMethodListener.class, MyTestListener.class})
public class HoversTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void HoverTest(){

        hoversPage.onThePage();
        hoversPage.hoverToElements();

    }
}
