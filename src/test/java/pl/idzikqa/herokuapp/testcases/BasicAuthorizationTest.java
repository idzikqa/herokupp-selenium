package pl.idzikqa.herokuapp.testcases;

import org.testng.annotations.Test;
import pl.idzikqa.herokuapp.hooks.BaseTest;

public class BasicAuthorizationTest extends BaseTest {
    @Test(groups = {"smoke"})
    public void basicAuthorizationTest() {

        basicAuthorizationPage.checkAuthorization();

    }
}
