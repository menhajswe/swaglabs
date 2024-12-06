package loginpage;

import config.ConfigReader;
import constants.SwagLabsConstants;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class TestLogin {
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

        // confirm url is inventory
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }
}
