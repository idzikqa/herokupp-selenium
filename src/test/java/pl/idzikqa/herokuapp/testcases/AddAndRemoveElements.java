package pl.idzikqa.herokuapp.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.idzikqa.herokuapp.hooks.BaseTest;

public class AddAndRemoveElements extends BaseTest {

    @DataProvider(name = "provider")
    public Object[][] feed() {
        return new Object[][]{{"2"},{"3"}};
    }

    @Test(dataProvider = "provider")
    public void addAndRemoveElements(String value) {

        Assert.assertTrue(addRemoveElements.onThePage());
        addRemoveElements.addElements(Integer.valueOf(value));
        addRemoveElements.deleteElements(Integer.valueOf(value));

    }
}
