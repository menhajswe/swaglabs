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
        login.loginUser();
        cart.addToCard();
        cart.navigateToCart();
        try {
            Thread.sleep(2000);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        Assertions.assertThat(cart.isCartEmpty()).isTrue();
    }

    @Test
    public void testCheckout() {
        login.loginUser();
        cart.addToCard();
        cart.checkout();
    }

    @Test
    public void testRemoveFromCart() {
        login.loginUser();
        cart.addToCard();
        cart.navigateToCart();
        cart.removeFromCard();
        Assertions.assertThat(cart.isCartEmpty()).isFalse();
    }

    @Test
    public void testNavigateToCart() {
        login.loginUser();
        cart.navigateToCart();
        Assertions.assertThat(driver.getCurrentUrl().contains("https://www.saucedemo.com/cart.html"));
    }
}
