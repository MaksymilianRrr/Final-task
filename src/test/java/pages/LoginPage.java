package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.*;

public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    WebElement fieldUsername;

    @FindBy(id = "password")
    WebElement fieldPassword;

    @FindBy(id = "login-button")
    WebElement buttonLogin;

    @FindBy(xpath = "//div[@class='error-message-container error']/h3")
    WebElement messageError;

    @FindBy(xpath = "//button[@class='error-button']")
    WebElement buttonClose;

    public void enterUsername(String username) {
        fieldUsername.clear();
        fieldUsername.sendKeys(username);
    }

    public void enterPassword(String password) {
        fieldPassword.clear();
        fieldPassword.sendKeys(password);
    }

    public void pressButtonLogin() {
        buttonLogin.click();
    }

    public  void closeNotification() {
        buttonClose.click();
    }

    public void assertThatFieldsAreHighlighted() {
        assertEquals(fieldUsername.getAttribute("class"), "input_error form_input error", "Field is not highlighted!");
        assertEquals(fieldPassword.getAttribute("class"), "input_error form_input error", "Field is not highlighted!");
    }

    public void assertThatFieldsAreNotHighlighted() {
        assertEquals(fieldUsername.getAttribute("class"), "input_error form_input", "Field is highlighted!");
        assertEquals(fieldPassword.getAttribute("class"), "input_error form_input", "Field is highlighted!");
    }

    public void assertThatNotificationIsEquals(String expectedMessage) {
        assertEquals(messageError.getText(), expectedMessage, "Inappropriate message!");
    }

    public void assertThatAllElementsAreDisplayed() {
        assertThatElementIsDisplayed(fieldUsername);
        assertThatElementIsDisplayed(fieldPassword);
        assertThatElementIsDisplayed(buttonLogin);
    }

    public void assertThatMainPageIsOpened() {
        assertThatElementIsNotDisplayed(fieldUsername);
        assertThatElementIsNotDisplayed(fieldPassword);
        assertThatElementIsNotDisplayed(buttonLogin);
    }
}