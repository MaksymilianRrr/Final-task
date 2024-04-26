package tests;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

public class MainPageMenuTest extends BaseTest {
    MainPage stepsMain;
    LoginPage stepsLogin;

    @AfterGroups("needLogin")
    public void login() {
        stepsLogin = loginPageSteps.login(username, password);
    }

    @AfterGroups("goBack")
    public void goBack() {
        getDriver().navigate().back();
    }

    @Test(priority = -1)
    public void testMenuOptionDisplaying() {
        stepsMain = mainPageSteps.openMenu();
        stepsMain.assertThatAllMenuOptionAreDisplayedCorrectly();
        stepsMain = mainPageSteps.closeMenu();
    }

    @Test
    public void testMenuOptionAllItems() {
        stepsMain = mainPageSteps.selectMenuOptionAllItems();
        stepsMain.assertThatUrlIsEquals("https://www.saucedemo.com/inventory.html");
    }

    @Test(groups = "goBack")
    public void testMenuOptionAbout() {
        stepsMain = mainPageSteps.selectMenuOptionAbout();
        stepsMain.assertThatUrlIsEquals("https://saucelabs.com/");
    }

    @Test(priority = 2, groups = "needLogin")
    public void testMenuOptionLogout() {
        stepsMain = mainPageSteps.selectMenuOptionLogout();
        stepsMain.assertThatUrlIsEquals("https://www.saucedemo.com/");
    }

    @Test
    public void testMenuOptionResetAppState() {
        stepsMain = mainPageSteps.selectMenuOptionResetAppState();
        stepsMain.assertThatInventoryCountIsEquals(0);
        getDriver().navigate().refresh();
        stepsMain.assertThatAllElementsAreDisplayedCorrectly();
    }
}