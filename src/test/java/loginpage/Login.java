package loginpage;

import config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
    private WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void loginUser() {
        By userIdPath = By.xpath("//*[@id=\"user-name\"]");
        By passwordPath = By.xpath("//input[@id='password']");
        By loginButton = By.xpath("//input[@id='login-button']");
        WebElement userElement = driver.findElement(userIdPath);
        WebElement passwordElement = driver.findElement(passwordPath);
        WebElement loginBtnElement = driver.findElement(loginButton);

        //Login
        userElement.sendKeys(ConfigReader.getStandardUserName());
        passwordElement.sendKeys(ConfigReader.getPassword());
        /*
        userElement.sendKeys("standard_user");
        passwordElement.sendKeys("secret_sauce");
         */
        loginBtnElement.click();
    }

    public void logout() {
        // Navigate to the list
        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
        driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
        System.out.println("Signed out");
    }
}
