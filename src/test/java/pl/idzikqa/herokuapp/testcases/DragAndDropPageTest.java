package pl.idzikqa.herokuapp.testcases;

import org.testng.annotations.Test;
import pl.idzikqa.herokuapp.hooks.BaseTest;

public class DragAndDropPageTest extends BaseTest {
    @Test
    public void DragAndDrop() {

        dragAndDropPage.onThePage();
        dragAndDropPage.dragAndDropHTML5();

    }
}
