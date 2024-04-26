package tests;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.Test;
import pages.CheckoutOnePage;

public class CheckoutOnePageTest extends BaseTest {
    CheckoutOnePage stepsCheckoutOne;

    @AfterGroups(groups = "openCheckoutOneAgain")
    public void openAgain() {
        stepsCheckoutOne = checkoutOnePageSteps.open();
    }

    @Test(priority = -1)
    public void testElementsDisplaying() {
        stepsCheckoutOne = checkoutOnePageSteps.open();
        stepsCheckoutOne.assertThatAllElementsAreDisplayedCorrectly();
    }

    @Test(groups = "openCheckoutOneAgain")
    public void testButtonCancel() {
        stepsCheckoutOne = checkoutOnePageSteps.buttonCancel();
        stepsCheckoutOne.assertThatCartPageOpens();
    }

    @Test(dataProvider = "checkoutOneData")
    public void testNotifications(String firstName, String lastName, String postalCode, String message) {
        stepsCheckoutOne = checkoutOnePageSteps.enterData(firstName, lastName, postalCode);
        stepsCheckoutOne.assertThatMessageIsEquals(message);
    }

    @Test
    public void testCloseMessage() {
        stepsCheckoutOne = checkoutOnePageSteps.closeMessage();
        stepsCheckoutOne.assertThatFieldIsNotHighlighted();
    }

    @Test(priority = 1)
    public void testButtonContinue() {
        stepsCheckoutOne = checkoutOnePageSteps.enterData("firstName", "lastName", "postalCode");
        stepsCheckoutOne.assertThatCheckoutTwoPageOpens();
    }
}