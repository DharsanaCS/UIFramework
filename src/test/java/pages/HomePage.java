package pages;

import org.openqa.selenium.WebDriver;
import util.ConfigPropertyConstants;
import util.ConfigProvider;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public ProductListingPage navigateToHomepage(){
        String applicationURL = ConfigProvider.getInstance().getProperty(ConfigPropertyConstants.URL);
        driver.navigate().to(applicationURL);
        return new ProductListingPage(driver);
    }
}
