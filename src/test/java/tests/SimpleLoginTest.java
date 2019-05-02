package tests;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;


public class SimpleLoginTest extends BaseTest{




    @Test(groups ="smoke")
    public void testLogin()  {


        LoginPage loginPage = new LoginPage(driver);
        Reporter.log("Opened browser with application url",true);
        loginPage.login("spree@example.com","spree123");
        Reporter.log("Logged in with valid credentials",true);
        assertTrue(driver.findElement(By.linkText("My Account")).isDisplayed());
        Reporter.log("Verified the presence of My Account link",true);
        assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
        Reporter.log("Verified the presence of logout link",true);


    }



}
