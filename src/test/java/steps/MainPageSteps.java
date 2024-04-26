package steps;

import pages.MainPage;

public class MainPageSteps {

    private final MainPage mainPage = new MainPage();

    public MainPage open() {
        return new MainPage();
    }

    public MainPage openMenu() {
        mainPage.pressButtonMenu();
        return new MainPage();
    }

    public MainPage closeMenu() {
        mainPage.pressButtonCloseMenu();
        return new MainPage();
    }

    public MainPage selectMenuOptionAllItems() {
        mainPage.pressButtonBasket();
        mainPage.pressButtonMenu();
        mainPage.pressMenuOption(0);
        return new MainPage();
    }

    public MainPage selectMenuOptionAbout() {
        mainPage.pressButtonMenu();
        mainPage.pressMenuOption(1);
        return new MainPage();
    }

    public MainPage selectMenuOptionLogout() {
        mainPage.pressButtonMenu();
        mainPage.pressMenuOption(2);
        return new MainPage();
    }

    public MainPage selectMenuOptionResetAppState() {
        mainPage.pressButtonInventory(0);
        mainPage.pressButtonInventory(2);
        mainPage.pressButtonMenu();
        mainPage.pressMenuOption(3);
        return new MainPage();
    }

    public MainPage goToTwitterPage() {
        mainPage.pressButtonTwitter();
        return new MainPage();
    }

    public MainPage goToFacebookPage() {
        mainPage.pressButtonFacebook();
        return new MainPage();
    }

    public MainPage goToLinkedInPage() {
        mainPage.pressButtonLinkedIn();
        return new MainPage();
    }

    public MainPage buttonInventory(int buttonOrder) {
        mainPage.pressButtonInventory(buttonOrder);
        return new MainPage();
    }

    public MainPage buttonsInventoryAll() {
        for (int i = 0; i < 6; i++) {
            mainPage.pressButtonInventory(i);
        }
        return new MainPage();
    }

    public MainPage setSorting(int optionOrder) {
        mainPage.selectSorting(optionOrder);
        return new MainPage();
    }
}