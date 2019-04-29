package tests;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;


public class SimpleLoginTest extends BaseTest{


    private String applicationURL = "https://spree-vapasi.herokuapp.com";



    @Test(groups ="smoke")
    public void testLogin(){


        login("spree@example.com","spree123");
        assertTrue(driver.findElement(By.linkText("My Account")).isDisplayed());
        assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());


    }

    private void login(String userName, String password) {


        driver.navigate().to(applicationURL);

        driver.findElement(By.id("link-to-login")).click();

        driver.findElement(By.id("spree_user_email")).sendKeys(userName);
        driver.findElement(By.id("spree_user_password")).sendKeys(password);
        driver.findElement(By.name("commit")).click();
    }


}
