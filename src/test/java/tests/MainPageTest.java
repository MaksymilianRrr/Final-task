package tests;

import org.testng.annotations.Test;
import pages.MainPage;

public class MainPageTest extends BaseTest {
    MainPage stepsMain;

    @Test(priority = -1)
    public void testElementsDisplaying() {
        stepsMain = mainPageSteps.open();
        stepsMain.assertThatAllElementsAreDisplayedCorrectly();
        stepsMain.assertThatInventoryCountIsEquals(0);
    }

    @Test
    public void testButtonTwitter() {
        stepsMain = mainPageSteps.goToTwitterPage();
        stepsMain.assertThatUrlInNewTabIsContains("https://twitter.com/saucelabs");
    }

    @Test
    public void testButtonFacebook() {
        stepsMain = mainPageSteps.goToFacebookPage();
        stepsMain.assertThatUrlInNewTabIsContains("https://www.facebook.com/saucelabs");
    }

    @Test
    public void testButtonLinkedIn() {
        stepsMain = mainPageSteps.goToLinkedInPage();
        stepsMain.assertThatUrlInNewTabIsContains("https://www.linkedin.com/");
    }

    @Test(priority = 1)
    public void testButtonInventoryAdd() {
        stepsMain = mainPageSteps.buttonInventory(0);
        stepsMain.assertThatButtonTitleIsEquals(0, "REMOVE");
        stepsMain.assertThatInventoryCountIsEquals(1);
    }

    @Test(dependsOnMethods = "testButtonInventoryAdd")
    public void testButtonInventoryRemove() {
        stepsMain = mainPageSteps.buttonInventory(0);
        stepsMain.assertThatButtonTitleIsEquals(0, "ADD TO CART");
        stepsMain.assertThatInventoryCountIsEquals(0);
    }

    @Test(dependsOnMethods = "testButtonInventoryRemove")
    public void testButtonInventoryAddAll() {
        stepsMain = mainPageSteps.buttonsInventoryAll();
        for (int i = 0; i < 6; i++) {
            stepsMain.assertThatButtonTitleIsEquals(i, "REMOVE");
        }
        stepsMain.assertThatInventoryCountIsEquals(6);
    }

    @Test(dependsOnMethods = "testButtonInventoryAddAll")
    public void testButtonInventoryRemoveAll() {
        stepsMain = mainPageSteps.buttonsInventoryAll();
        for (int i = 0; i < 6; i++) {
            stepsMain.assertThatButtonTitleIsEquals(i, "ADD TO CART");
        }
        stepsMain.assertThatInventoryCountIsEquals(0);
    }

    @Test(dataProvider = "sortingData")
    public void testSorting(int optionOrder, int[] orderArray) {
        stepsMain = mainPageSteps.setSorting(optionOrder);
        stepsMain.assertThatSortingIsCorrect(orderArray);
    }
}