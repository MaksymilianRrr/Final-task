package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;

public class CheckoutOnePage extends BasePage {

    @FindBy(id = "first-name")
    WebElement fieldFirstName;

    @FindBy(id = "last-name")
    WebElement fieldLastName;

    @FindBy(id = "postal-code")
    WebElement fieldPostalCode;

    @FindBy(id = "cancel")
    WebElement buttonCancel;

    @FindBy(id = "continue")
    WebElement buttonContinue;

    @FindBy(xpath = "//span[@class='title']")
    WebElement title;

    @FindBy(xpath = "//div[@class='error-message-container error']/h3")
    WebElement messageError;

    @FindBy(xpath = "//button[@class='error-button']")
    WebElement buttonCloseMessage;

    public void enterFirstName(String value) {
        fieldFirstName.clear();
        fieldFirstName.sendKeys(value);
    }

    public void enterLastName(String value) {
        fieldLastName.clear();
        fieldLastName.sendKeys(value);
    }

    public void enterPostalCode(String value) {
        fieldPostalCode.clear();
        fieldPostalCode.sendKeys(value);
    }

    public void pressButtonCancel() {
        buttonCancel.click();
    }

    public void pressButtonContinue() {
        buttonContinue.click();
    }

    public void pressButtonCloseMessage() {
        buttonCloseMessage.click();
    }

    public void assertThatAllElementsAreDisplayedCorrectly() {
        assertThatElementIsDisplayed(fieldFirstName);
        assertThatElementIsDisplayed(fieldLastName);
        assertThatElementIsDisplayed(fieldPostalCode);
        assertThatElementIsDisplayed(buttonCancel);
        assertThatElementIsDisplayed(buttonContinue);
    }

    public void assertThatCartPageOpens() {
        assertThatElementTitleIsEquals(title, "YOUR CART", "Incorrect header!");
    }

    public void assertThatMessageIsEquals(String message) {
        assertThatElementTitleIsEquals(messageError, message);
    }

    public void assertThatFieldIsNotHighlighted() {
        assertEquals(fieldFirstName.getAttribute("class"), "input_error form_input", "Field is highlighted!");
    }

    public void assertThatCheckoutTwoPageOpens() {
        assertThatElementTitleIsEquals(title,"CHECKOUT: OVERVIEW", "Incorrect header!");
    }
}