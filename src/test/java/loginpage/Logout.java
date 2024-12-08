package loginpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Logout {
    private WebDriver driver;

    public Logout(WebDriver driver) {
        this.driver = driver;
    }

    public void logoutUser() {
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
