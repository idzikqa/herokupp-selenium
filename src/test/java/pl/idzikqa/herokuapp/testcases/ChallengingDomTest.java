package pl.idzikqa.herokuapp.testcases;

import org.testng.annotations.Test;
import pl.idzikqa.herokuapp.hooks.BaseTest;

public class ChallengingDomTest extends BaseTest {
    @Test
    public void readTableTest() {

        challengingDomPage.onThePage();
        challengingDomPage.readTable();
        challengingDomPage.clickButtonsWork();
    }
}
