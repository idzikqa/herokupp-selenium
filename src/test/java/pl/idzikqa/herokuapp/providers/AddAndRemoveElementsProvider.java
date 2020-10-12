package pl.idzikqa.herokuapp.providers;

import org.testng.annotations.DataProvider;
import pl.idzikqa.herokuapp.tools.ExcelMethods;

public class AddAndRemoveElementsProvider {
    @DataProvider(name = "excelProvider")
    public Object[][] feedWithDataFromExcel() {
        return ExcelMethods.getDataFromOneCell("AddAndRemoveElements");
    }
}
