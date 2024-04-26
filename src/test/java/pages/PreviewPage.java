package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.*;

public class PreviewPage extends BasePage {

    @FindBy(xpath = "//div[@class='inventory_details_name large_size']")
    WebElement sectionLargeName;

    @FindBy(xpath = "//div[@class='inventory_details_desc large_size']")
    WebElement sectionLargeDesc;

    @FindBy(xpath = "//div[@class='inventory_details_price']")
    WebElement sectionLargePrice;

    @FindBy(xpath = "//div[@class='inventory_details_img_container']/img")
    WebElement sectionLargePicture;

    @FindBy(id = "back-to-products")
    WebElement buttonBack;

    @FindBy(xpath = "//span[@class='title']")
    WebElement pageHeader;

    public void pressButtonBack() {
        buttonBack.click();
    }

    public void assertThatNameTextIsEquals(String expectedName) {
        assertThatElementTitleIsEquals(sectionLargeName, expectedName, "Incorrect name!");
    }

    public void assertThatDescTextIsEquals(String expectedDesc) {
        assertThatElementTitleIsEquals(sectionLargeDesc, expectedDesc, "Incorrect description!");
    }

    public void assertThatPriceIsEquals(String expectedPrice) {
        assertThatElementTitleIsEquals(sectionLargePrice, expectedPrice, "Incorrect price!");
    }

    public void assertThatPictureNameIsEquals(String expectedSrc) {
        assertTrue(sectionLargePicture.getAttribute("src").contains(expectedSrc), "Incorrect picture!");
    }

    public void assertThatMainPageOpens() {
        assertThatElementTitleIsEquals(pageHeader, "PRODUCTS", "Incorrect header!");
    }
}