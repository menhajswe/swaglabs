package loginpage;

import config.ConfigReader;
import constants.SwagLabsConstants;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestLogin {
    WebDriver driver;
    Login login;
    Logout logout;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.get(SwagLabsConstants.BASE_URL);
        login = new Login(driver);
        logout = new Logout(driver);
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testLogin() {
        // confirm url is inventory
        login.loginUser();
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @Test
    public void testLogout() {
        login.loginUser();
        logout.logoutUser();
        assertEquals("https://www.saucedemo.com/", driver.getCurrentUrl());

    }
}
