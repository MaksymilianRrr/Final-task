package steps;

import pages.CartPage;
import pages.MainPage;

public class CartPageSteps {

    private final CartPage cartPage = new CartPage();
    private final MainPage mainPage = new MainPage();

    public CartPage open() {
        mainPage.pressButtonBasket();
        return new CartPage();
    }

    public CartPage goBackToMainPage() {
        cartPage.pressButtonContinueShopping();
        return new CartPage();
    }

    public CartPage removeInventory(int buttonOrder) {
        cartPage.pressButtonContinueShopping();
        mainPage.pressButtonInventory(buttonOrder);
        mainPage.pressButtonBasket();
        cartPage.pressButtonRemove(0);
        return new CartPage();
    }

    public CartPage addAllInventories(int i) {
        cartPage.pressButtonContinueShopping();
        mainPage.pressButtonInventory(i);
        mainPage.pressButtonBasket();
        return new CartPage();
    }
}