package loginpage;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Cart {
    private WebDriver driver;
    private Login login;


    public Cart(WebDriver driver) {
        this.driver = driver;
        login = new Login(driver);

    }

    public void addToCard() {
        // Elements and xpath
        login.loginUser();
        By bikeItem = By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']");
        By fleeceItem = By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']");

        // find elements
        WebElement bikeElement = driver.findElement(bikeItem);
        WebElement fleeceElement = driver.findElement(fleeceItem);

        bikeElement.click();
        fleeceElement.click();
    }

    public void removeFromCard() {
        // Elements and xpath
        By bikeItem = By.xpath("//button[@id='remove-sauce-labs-bike-light']");
        By fleeceItem = By.xpath("//button[@id='remove-sauce-labs-fleece-jacket']");

        // find elements
        try {
            WebElement bikeElement = driver.findElement(bikeItem);
            WebElement fleeceElement = driver.findElement(fleeceItem);

            bikeElement.click();
            fleeceElement.click();
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean confirmItemsAdded() {
        By cartPath = By.xpath("//a[@class='shopping_cart_link']");
        driver.findElement(cartPath).click();
        assertThat(driver.getCurrentUrl()).contains("https://www.saucedemo.com/cart.html");

        WebElement removeButtonElement = driver.findElement(By.xpath("//button[@id='remove-sauce-labs-bike-light']"));
        if (removeButtonElement.getText().contains("Remove")) {
            return true;
        } else {
            return false;
        }

//        By bikeItem = By.xpath("//button[@id='remove-sauce-labs-bike-light']");
//        By fleeceItem = By.xpath("//button[@id='remove-sauce-labs-fleece-jacket']");
//        WebElement bikeElement = driver.findElement(bikeItem);
//        WebElement fleeceElement = driver.findElement(fleeceItem);
//        try {
//            assertThat(bikeElement.getText()).contains("Sauce Labs Bike Light");
//            assertThat(fleeceElement.getText()).contains("Sauce Labs Fleece Jacket");
//        } catch (Exception ex) {
//            NotFoundException e = (NotFoundException) ex;
//            System.out.println(e.getMessage());
//            return false;
//        }

//        return true;
    }

    public void checkout() {
        addToCard();
        if (!confirmItemsAdded()) {
            return;
        }
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        String currentUrl = driver.getCurrentUrl();
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
