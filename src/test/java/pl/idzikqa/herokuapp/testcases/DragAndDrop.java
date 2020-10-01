package pl.idzikqa.herokuapp.testcases;

import org.testng.annotations.Test;
import pl.idzikqa.herokuapp.hooks.BaseTest;

public class DragAndDrop extends BaseTest {
    @Test
    public void DragAndDrop() {

        dragAndDrop.onThePage();
        dragAndDrop.dragAndDropHTML5();

    }
}
