package loginpage;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Cart {
    private WebDriver driver;


    public Cart(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCard() {
        By bikeItem = By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']");
        By fleeceItem = By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']");
        // find elements
        driver.findElement(bikeItem).click();
        driver.findElement(fleeceItem).click();
    }

    public void navigateToCart() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        WebElement test = driver.findElement(By.xpath("//div[@class=\"cart_list\"]"));
    }

    public void removeFromCard() {
        By bikeItem = By.xpath("//button[@id='remove-sauce-labs-bike-light']");
        By fleeceItem = By.xpath("//button[@id='remove-sauce-labs-fleece-jacket']");
        // find elements
        try {
            driver.findElement(bikeItem).click();
            driver.findElement(fleeceItem).click();
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean isCartEmpty() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        WebElement shoppingCart = driver.findElement(By.xpath("//div[@class=\"cart_list\"]"));
        List<WebElement> cartItems = shoppingCart.findElements(By.xpath("//div[@class='cart_item']"));
        if (cartItems.size() == 0) {
            return false;
        }
        return true;
    }

    public void checkout() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Tester");
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("22033");
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        driver.findElement(By.xpath("//button[@id='finish']")).click();
        // screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(screenshot, new File("screenshot.png"));
            System.out.println("Screenshot taken and saved!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
