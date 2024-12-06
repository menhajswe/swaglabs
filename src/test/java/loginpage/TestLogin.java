package loginpage;

import config.ConfigReader;
import constants.SwagLabsConstants;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class TestLogin {
    private static final Logger log = LoggerFactory.getLogger(TestLogin.class);
    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.get(SwagLabsConstants.BASE_URL);
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testLogin() {
        // confirm url is inventory
        login();
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @Test
    public void testLogout() {
        login();
        logout();
        Assertions.assertEquals("https://www.saucedemo.com/", driver.getCurrentUrl());

    }

    private void login() {
        By userIdPath = By.xpath("//*[@id=\"user-name\"]");
        By passwordPath = By.xpath("//input[@id='password']");
        By loginButton = By.xpath("//input[@id='login-button']");
        WebElement userElement = driver.findElement(userIdPath);
        WebElement passwordElement = driver.findElement(passwordPath);
        WebElement loginElement = driver.findElement(loginButton);

        //Login
        userElement.sendKeys(ConfigReader.getStandardUserName());
        passwordElement.sendKeys(ConfigReader.getPassword());
        /*
        userElement.sendKeys("standard_user");
        passwordElement.sendKeys("secret_sauce");
         */
        loginElement.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void logout() {
        By menuPath = By.xpath("//button[@id='react-burger-menu-btn']");
        WebElement menuElement = driver.findElement(menuPath);
        menuElement.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        By buttonPath = By.xpath("//a[@id='logout_sidebar_link']");
        driver.findElement(buttonPath).click();

    }
}
