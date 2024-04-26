package tests;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import steps.*;

import java.io.File;
import java.time.Duration;

public abstract class BaseTest {
    private static WebDriver driver;
    public static WebDriverWait wait;

    LoginPageSteps loginPageSteps;
    MainPageSteps mainPageSteps;
    PreviewPageSteps previewPageSteps;
    CartPageSteps  cartPageSteps;
    CheckoutOnePageSteps checkoutOnePageSteps;

    String username = "standard_user"; //standard_user  problem_user
    String password = "secret_sauce";

    @BeforeClass
    public void beforeClass(){
        loginPageSteps = new LoginPageSteps();
        mainPageSteps = new MainPageSteps();
        previewPageSteps = new PreviewPageSteps();
        cartPageSteps = new CartPageSteps();
        checkoutOnePageSteps = new CheckoutOnePageSteps();
    }

    @BeforeSuite
    public void beforeSuite() {
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @AfterSuite
    public void afterSuite() {
        driver.quit();
    }

    @DataProvider
    public Object[][] loginData() {
        return new Object [][] {
                {"", "", "Epic sadface: Username is required"},
                {"222", "", "Epic sadface: Password is required"},
                {"333", "333", "Epic sadface: Username and password do not match any user in this service"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."}
        };
    }

    @DataProvider
    public static Object[][] sortingData() {
        int[] order3 = {5, 4, 1, 3, 0, 2};
        int[] order2 = {2, 0, 1, 3, 4, 5};
        int[] order1 = {3, 2, 5, 1, 0, 4};
        int[] order0 = {4, 0, 1, 5, 2, 3};
        return new Object[][]{
                {3, order3},
                {2, order2},
                {1, order1},
                {0, order0}
        };
    }

    @DataProvider
    public static Object[][] previewData() {
        return new Object[][]{
                {0, "Sauce Labs Backpack", "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.", "$29.99", "/static/media/sauce-backpack-1200x1500.34e7aa42.jpg"},
                {1, "Sauce Labs Bike Light", "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.", "$9.99", "/static/media/bike-light-1200x1500.a0c9caae.jpg"},
                {2, "Sauce Labs Bolt T-Shirt", "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.", "$15.99", "/static/media/bolt-shirt-1200x1500.c0dae290.jpg"},
                {3, "Sauce Labs Fleece Jacket", "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.", "$49.99", "/static/media/sauce-pullover-1200x1500.439fc934.jpg"},
                {4, "Sauce Labs Onesie", "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.", "$7.99", "/static/media/red-onesie-1200x1500.1b15e1fa.jpg"},
                {5, "Test.allTheThings() T-Shirt (Red)", "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.", "$15.99", "/static/media/red-tatt-1200x1500.e32b4ef9.jpg"}
        };
    }

    @DataProvider
    public static Object[][] inventoryData() {
        return new Object[][]{
                {0, "Sauce Labs Backpack", "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.", "$29.99"},
                {1, "Sauce Labs Bike Light", "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.", "$9.99"},
                {2, "Sauce Labs Bolt T-Shirt", "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.", "$15.99"},
                {3, "Sauce Labs Fleece Jacket", "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.", "$49.99"},
                {4, "Sauce Labs Onesie", "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.", "$7.99"},
                {5, "Test.allTheThings() T-Shirt (Red)", "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.", "$15.99"}
        };
    }

    @DataProvider
    public static Object[][] checkoutOneData() {
        return new Object[][]{
                {"", "", "", "Error: First Name is required"},
                {"111", "", "", "Error: Last Name is required"},
                {"222", "222", "", "Error: Postal Code is required"}
        };
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }
}