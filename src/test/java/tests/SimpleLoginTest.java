package tests;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;


public class SimpleLoginTest extends BaseTest{


    private String applicationURL = "https://spree-vapasi.herokuapp.com";



    @Test(groups ="smoke")
    public void testLogin(){

        driver.navigate().to(applicationURL);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("spree@example.com","spree123");
        assertTrue(driver.findElement(By.linkText("My Account")).isDisplayed());
        assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());


    }



}
