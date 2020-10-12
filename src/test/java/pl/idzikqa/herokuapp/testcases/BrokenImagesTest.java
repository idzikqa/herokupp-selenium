package pl.idzikqa.herokuapp.testcases;

import org.testng.annotations.Test;
import pl.idzikqa.herokuapp.hooks.BaseTest;

public class BrokenImagesTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void brokenImages() {

        brokenImages.onThePage();
        brokenImages.checkAllImages();

    }
}
