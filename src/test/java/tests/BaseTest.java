package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BaseTest {

    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setDriver(){

        String currentUsersWorkingDir = System.getProperty("user.dir");
        String applicationURL = "https://spree-vapasi.herokuapp.com";
        System.out.println("Dir is " + currentUsersWorkingDir);
        System.setProperty("webdriver.chrome.driver",currentUsersWorkingDir+"/src/test/resources/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to(applicationURL);


    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.close();
        driver.quit();

    }


}
