package pl.idzikqa.herokuapp.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.idzikqa.herokuapp.hooks.BaseTest;

public class AddAndRemoveElementsTest extends BaseTest {

    @DataProvider(name = "provider")
    public Object[][] feed() {
        return new Object[][]{{"2"},{"3"}};
    }

    @Test(dataProvider = "provider")
    public void addAndRemoveElements(String value) {

        addRemoveElementsPage.onThePage();
        addRemoveElementsPage.addElements(Integer.valueOf(value));
        addRemoveElementsPage.deleteElements(Integer.valueOf(value));

    }
}
