package steps;

import pages.CartPage;
import pages.CheckoutOnePage;

public class CheckoutOnePageSteps {
    private final CheckoutOnePage checkoutOnePage = new CheckoutOnePage();
    private final CartPage cartPage = new CartPage();

    public CheckoutOnePage open() {
        cartPage.pressButtonCheckout();
        return new CheckoutOnePage();
    }

    public CheckoutOnePage buttonCancel() {
        checkoutOnePage.pressButtonCancel();
        return new CheckoutOnePage();
    }

    public CheckoutOnePage enterData(String firstName, String lastName, String postalCode) {
        checkoutOnePage.enterFirstName(firstName);
        checkoutOnePage.enterLastName(lastName);
        checkoutOnePage.enterPostalCode(postalCode);
        checkoutOnePage.pressButtonContinue();
        return new CheckoutOnePage();
    }

    public CheckoutOnePage closeMessage() {
        checkoutOnePage.pressButtonContinue();
        checkoutOnePage.pressButtonCloseMessage();
        return new CheckoutOnePage();
    }
}