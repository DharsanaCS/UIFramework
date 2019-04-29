package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void login(String userName, String password) {

        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys(userName);
        driver.findElement(By.id("spree_user_password")).sendKeys(password);
        driver.findElement(By.name("commit")).click();
    }

}
