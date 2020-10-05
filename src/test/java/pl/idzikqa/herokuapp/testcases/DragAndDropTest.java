package pl.idzikqa.herokuapp.testcases;

import org.testng.annotations.Test;
import pl.idzikqa.herokuapp.hooks.BaseTest;

public class DragAndDropTest extends BaseTest {
    @Test(groups = {"smoke"})
    public void DragAndDrop() {

        dragAndDropPage.onThePage();
        dragAndDropPage.dragAndDropHTML5();

    }
}
