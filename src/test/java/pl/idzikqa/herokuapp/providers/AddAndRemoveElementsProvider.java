package pl.idzikqa.herokuapp.providers;

import org.testng.annotations.DataProvider;

public class AddAndRemoveElementsProvider {
    @DataProvider(name = "provider")
    public Object[][] feed() {
        return new Object[][]{{"2"},{"3"}};
    }
}
