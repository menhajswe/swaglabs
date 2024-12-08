package loginpage;

import constants.SwagLabsConstants;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCart {
    WebDriver driver;
    Login login;
    Cart cart;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.get(SwagLabsConstants.BASE_URL);
        login = new Login(driver);
        cart = new Cart(driver);
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testAddToCard() {
        cart.addToCard();
        Assertions.assertThat(cart.confirmItemsAdded()).isTrue();
    }

    @Test
    public void testCheckout() {
        cart.checkout();
    }
}
