package pl.idzikqa.herokuapp.testcases;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;
import pl.idzikqa.herokuapp.hooks.BaseTest;
import pl.idzikqa.herokuapp.providers.AddAndRemoveElementsProvider;

public class AddAndRemoveElementsTest extends BaseTest {


    @Test(dataProvider = "provider", dataProviderClass = AddAndRemoveElementsProvider.class, groups = {"smoke"})
    public void addAndRemoveElements(String value) {

        addRemoveElementsPage.onThePage();
        test.log(LogStatus.INFO,"Extent Reports: on the Page");
        addRemoveElementsPage.addElements(Integer.valueOf(value));
        test.log(LogStatus.INFO,"Extent Reports: added elements");
        addRemoveElementsPage.deleteElements(Integer.valueOf(value));
        test.log(LogStatus.INFO,"Extent Reports: removed element");
        test.log(LogStatus.PASS,"Extent Reports: added and removed elements");

    }
}
