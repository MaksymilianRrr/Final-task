package pages;

import lombok.SneakyThrows;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class MainPage extends BasePage {
    @FindBy(id = "react-burger-menu-btn")
    WebElement buttonMenu;

    @FindBy(id = "react-burger-cross-btn")
    WebElement buttonCloseMenu;

    @FindAll({@FindBy(xpath = "//nav[@class='bm-item-list']/a")})
    List<WebElement> menuOptions;

    @FindBy(id = "shopping_cart_container")
    WebElement buttonBasket;

    @FindAll({@FindBy(xpath = "//button[contains(@class, 'btn_inventory')]")})
    List<WebElement> buttonsInventory;

    @FindBy(xpath = "//a[@class='shopping_cart_link']/span")
    WebElement inventoryCounter;

    @FindBy(xpath = "//span[@class='title']")
    WebElement title;

    @FindBy(xpath = "//a[text()='Twitter']")
    WebElement buttonTwitter;

    @FindBy(xpath = "//a[text()='Facebook']")
    WebElement buttonFacebook;

    @FindBy(xpath = "//a[text()='LinkedIn']")
    WebElement buttonLinkedIn;

    @FindBy(className = "product_sort_container")
    WebElement select;

    @FindAll({@FindBy(xpath = "//img/ancestor::a[@href='#']")})
    List<WebElement> picturesInventory;

    @SneakyThrows
    public void pressButtonMenu() {
        Thread.sleep(1000);
        buttonMenu.click();
        Thread.sleep(500);
    }

    public void pressButtonCloseMenu(){
        buttonCloseMenu.click();
    }

    public void pressMenuOption(int optionOrder) {
        wait.until(ExpectedConditions.attributeToBe(menuOptions.get(optionOrder), "tabindex", "0"));
        menuOptions.get(optionOrder).click();
    }

    public void pressButtonBasket() {
        buttonBasket.click();
        wait.until(ExpectedConditions.textToBePresentInElement(title, "YOUR CART"));
    }

    public void pressButtonInventory(int buttonOrder) {
        wait.until(ExpectedConditions.textToBePresentInElement(title, "PRODUCT"));
        buttonsInventory.get(buttonOrder).click();
    }

    public void pressButtonTwitter() {
        buttonTwitter.click();
    }

    public void pressButtonFacebook() {
        buttonFacebook.click();
    }

    public void pressButtonLinkedIn() {
        buttonLinkedIn.click();
    }

    public void clickOnPicture(int pictureOrder) {
        wait.until(ExpectedConditions.textToBePresentInElement(title, "PRODUCT"));
        picturesInventory.get(pictureOrder).click();
    }

    public void selectSorting(int optionOrder) {
        Select selectSorting = new Select(select);
        selectSorting.selectByIndex(optionOrder);
    }

    public int getBasketCount() {
        try {
            return Integer.parseInt(inventoryCounter.getText());
        } catch (NoSuchElementException e) {
            return 0;
        }
    }

    public void assertThatInventoryCountIsEquals(int expectedCount) {
        assertEquals(getBasketCount(), expectedCount, "Count mismatch!");
    }

    public void assertThatAllElementsAreDisplayedCorrectly() {
        assertThatElementIsDisplayed(buttonMenu);
        assertThatElementIsDisplayed(buttonBasket);
        for (WebElement element : buttonsInventory) {
            assertThatElementIsDisplayed(element);
            assertThatElementTitleIsEquals(element, "ADD TO CART");
        }
    }

    public void assertThatAllMenuOptionAreDisplayedCorrectly() {
        wait.until(ExpectedConditions.attributeToBe(menuOptions.get(0), "tabindex", "0"));
        String[] titles = {"ALL ITEMS", "ABOUT", "LOGOUT", "RESET APP STATE"};
        for (int i = 0; i < menuOptions.size(); i++) {
            assertThatElementTitleIsEquals(menuOptions.get(i), titles[i]);
        }
    }

    public void assertThatUrlInNewTabIsContains(String expectedUrl) {
        ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
        assertTrue(getDriver().getCurrentUrl().contains(expectedUrl), "Inappropriate URL!");
        getDriver().close();
        getDriver().switchTo().window(tabs.get(0));
    }

    public void assertThatButtonTitleIsEquals(int buttonOrder, String title) {
        assertThatElementTitleIsEquals(buttonsInventory.get(buttonOrder), title);
    }

    public void assertThatSortingIsCorrect(int[] order) {
        for (int i = 0; i < 6; i++) {
            assertTrue(picturesInventory.get(i).getAttribute("id").contains(String.valueOf(order[i])), "Wrong sorting!");
        }
    }
}