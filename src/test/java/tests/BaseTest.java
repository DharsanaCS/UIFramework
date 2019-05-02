package tests;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import util.ConfigPropertyConstants;
import util.ConfigProvider;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BaseTest {

    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp(){

        String applicationURL = getProperty(ConfigPropertyConstants.URL);


        try {
            setBrowserDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to(applicationURL);

    }

    protected String getProperty(String name) {
        return ConfigProvider.getInstance().getProperty(name);
    }

    public void setBrowserDriver() throws Exception {

        String browser = getProperty(ConfigPropertyConstants.BROWSER);
        String currentUsersWorkingDir = System.getProperty("user.dir");
        System.out.println("Dir is " + currentUsersWorkingDir);

        if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver",currentUsersWorkingDir+"/src/test/resources/chromedriver");
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("safari")){

            System.setProperty("webdriver.safari.driver","/usr/bin/safaridriver");
            driver = new SafariDriver();
            driver.manage().window().maximize();
        }
        else{
            throw new Exception("Incorrect browser value specified");
        }


    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp(ITestResult result) throws IOException {
        captureScreenshotIfFailed(result);
        driver.close();
        driver.quit();

    }

    public void captureScreenshotIfFailed(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE){
            takeScreenshot(result);
        }
    }

    private void takeScreenshot(ITestResult result) throws IOException {
        String currentUsersWorkingDir = System.getProperty("user.dir");
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File( currentUsersWorkingDir+"/src/test/snapshot/"+result.getMethod().getMethodName()+".png"));
    }


}
