package steps;

import pages.LoginPage;

public class LoginPageSteps {

    private final LoginPage loginPage = new LoginPage();

    public LoginPage login(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.pressButtonLogin();
        return new LoginPage();
    }

    public LoginPage login() {
        return new LoginPage();
    }

    public LoginPage closeMessage() {
        loginPage.pressButtonLogin();
        loginPage.closeNotification();
        return new LoginPage();
    }
}