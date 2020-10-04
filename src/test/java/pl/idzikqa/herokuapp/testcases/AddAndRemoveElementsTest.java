package pl.idzikqa.herokuapp.testcases;

import org.testng.annotations.Test;
import pl.idzikqa.herokuapp.hooks.BaseTest;
import pl.idzikqa.herokuapp.providers.AddAndRemoveElementsProvider;

public class AddAndRemoveElementsTest extends BaseTest {


    @Test(dataProvider = "provider", dataProviderClass = AddAndRemoveElementsProvider.class, groups = {"smoke"})
    public void addAndRemoveElements(String value) {

        addRemoveElementsPage.onThePage();
        addRemoveElementsPage.addElements(Integer.valueOf(value));
        addRemoveElementsPage.deleteElements(Integer.valueOf(value));

    }
}
