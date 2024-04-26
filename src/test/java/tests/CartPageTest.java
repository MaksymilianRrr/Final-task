package tests;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.Test;
import pages.CartPage;

public class CartPageTest extends BaseTest{
    private CartPage cartPage;

    @AfterGroups("openAgain")
    public void openAgain() {
        cartPage = cartPageSteps.open();
    }

    @Test(priority = -1)
    public void testElementsDisplaying() {
        cartPage = cartPageSteps.open();
        cartPage.assertThatAllElementAreDisplayedCorrectly();
    }

    @Test(groups = "openAgain")
    public void testButtonContinueShopping() {
        cartPage = cartPageSteps.goBackToMainPage();
        cartPage.assertThatMainPageOpens();
    }

    @Test
    public void testRemovingInventories() {
        cartPage = cartPageSteps.removeInventory(0);
        cartPage.assertThatInventoryIsDeleted();
        cartPage.assertThatInventoryCountIsEquals(0);
    }

    @Test(dataProvider = "inventoryData", dependsOnMethods = "testRemovingInventories")
    public void testInventoryData(int order, String name, String desc, String price) {
        cartPage = cartPageSteps.addAllInventories(order);
        cartPage.assertThatNameIsEquals(order, name);
        cartPage.assertThatDescIsEquals(order, desc);
        cartPage.assertThatPriceIsEquals(order, price);
        cartPage.assertThatInventoryCountIsEquals(order+1);
    }
}
