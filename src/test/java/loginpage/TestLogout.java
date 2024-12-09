package loginpage;

import constants.SwagLabsConstants;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLogout {
    WebDriver driver;
    Login userLogin;
    Logout logout;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.get(SwagLabsConstants.BASE_URL);
        userLogin = new Login(driver);
        logout = new Logout(driver);
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testLogout() {
        userLogin.loginUser();
        logout.logoutUser();
        assert driver.getCurrentUrl().contains("https://www.saucedemo.com/");

    }
}
