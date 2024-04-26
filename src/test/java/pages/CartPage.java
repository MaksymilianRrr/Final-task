package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartPage extends BasePage{
    @FindBy(id = "continue-shopping")
    WebElement buttonContinueShopping;

    @FindBy(id = "checkout")
    WebElement buttonCheckout;

    @FindBy(xpath = "//span[@class='title']")
    WebElement title;

    @FindBy(xpath = "//a[@class='shopping_cart_link']/span")
    WebElement inventoryCounter;

    @FindBy(xpath = "//div[@class='removed_cart_item']")
    WebElement sectionOfRemoved;

    @FindAll({@FindBy(xpath = "//button[text()='Remove']")})
    List<WebElement> buttonsRemove;

    @FindAll({@FindBy(xpath = "//div[@class='inventory_item_name']")})
    List<WebElement> inventoryName;

    @FindAll({@FindBy(xpath = "//div[@class='inventory_item_desc']")})
    List<WebElement> inventoryDesc;

    @FindAll({@FindBy(xpath = "//div[@class='inventory_item_price']")})
    List<WebElement> inventoryPrice;

    public void pressButtonContinueShopping() {
        buttonContinueShopping.click();
    }

    public void pressButtonRemove(int buttonOrder) {
        buttonsRemove.get(buttonOrder).click();
    }

    public void pressButtonCheckout() {
        buttonCheckout.click();
    }

    public int getBasketCount() {
        try {
            return Integer.parseInt(inventoryCounter.getText());
        } catch (NoSuchElementException e) {
            return 0;
        }
    }

    public void assertThatAllElementAreDisplayedCorrectly() {
        assertThatElementIsDisplayed(buttonContinueShopping);
        assertThatElementIsDisplayed(buttonCheckout);
        assertThatElementTitleIsEquals(title, "YOUR CART", "Incorrect header!");
    }

    public void assertThatMainPageOpens() {
        assertThatElementTitleIsEquals(title, "PRODUCTS", "Incorrect header!");
    }

    public void assertThatInventoryCountIsEquals(int expectedCount) {
        assertEquals(getBasketCount(), expectedCount, "Count mismatch!");
    }

    public void assertThatInventoryIsDeleted() {
        assertTrue(sectionOfRemoved.isEnabled(), "Element is not displayed!");
    }

    public void assertThatNameIsEquals(int inventoryOrder, String expectedName) {
        assertThatElementTitleIsEquals(inventoryName.get(inventoryOrder), expectedName, "Incorrect name!");
    }

    public void assertThatDescIsEquals(int inventoryOrder, String expectedDesc) {
        assertThatElementTitleIsEquals(inventoryDesc.get(inventoryOrder), expectedDesc, "Incorrect description!");
    }

    public void assertThatPriceIsEquals(int inventoryOrder, String expectedPrice) {
        assertThatElementTitleIsEquals(inventoryPrice.get(inventoryOrder), expectedPrice, "Incorrect price!");
    }
}