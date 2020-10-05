package pl.idzikqa.herokuapp.testcases;

import org.testng.annotations.Test;
import pl.idzikqa.herokuapp.hooks.BaseTest;

public class FileUploadTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void FileUploadTest(){

        fileUploadPage.onThePage();
        fileUploadPage.fileUpload("c://windows-version.txt");

    }
}
