package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTest extends BaseTest {
    private LoginPage steps;

    @Test
    public void testElementsDisplaying() {
        steps = loginPageSteps.login();
        steps.assertThatAllElementsAreDisplayed();
    }

    @Test(dataProvider = "loginData")
    public void testLoginWithWrongCredentials(String username, String password, String message) {
        steps = loginPageSteps.login(username, password);
        steps.assertThatFieldsAreHighlighted();
        steps.assertThatNotificationIsEquals(message);
    }

    @Test
    public void testClosingOfMessage() {
        steps = loginPageSteps.closeMessage();
        steps.assertThatFieldsAreNotHighlighted();
    }

    @Test(priority = 1)
    public void testLoginWithStandardUser() {
        steps = loginPageSteps.login(username, password);
        steps.assertThatMainPageIsOpened();
    }
}