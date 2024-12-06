package sample;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMainUrl {
    private static final String BASE_URL = "https://www.saucedemo.com";
    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        System.out.println("Setting up web driver and url");
    }

    @Test
    public void testBaseUrlTitle() {
        String title = driver.getTitle();
        assertEquals("Swag Labs", title);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
