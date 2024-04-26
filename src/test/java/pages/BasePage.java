package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;

import static org.testng.Assert.*;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        driver = BaseTest.getDriver();
        wait = BaseTest.getWait();
        PageFactory.initElements(driver, this);
    }

    public void assertThatElementIsDisplayed(WebElement element) {
        assertTrue(element.isDisplayed(), "Element is not displayed!");
    }

    public void assertThatElementIsNotDisplayed(WebElement element) {
        boolean checkIfExist = false;
        try{
            assertTrue(element.isDisplayed());
            checkIfExist = true;
        }catch (NoSuchElementException ignored){}
        assertFalse(checkIfExist, "Element still exist!");
    }

    public void assertThatUrlIsEquals(String expectedUrl) {
        assertEquals(driver.getCurrentUrl(), expectedUrl, "Inappropriate URL!");
    }

    public void assertThatElementTitleIsEquals(WebElement element, String expectedTitle) {
        assertEquals(element.getText(), expectedTitle, "Title mismatch!");
    }

    public void assertThatElementTitleIsEquals(WebElement element, String expectedTitle, String message) {
        assertEquals(element.getText(), expectedTitle, message);
    }

    public WebDriver getDriver(){
        return driver;
    }
}