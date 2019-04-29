package pages;

import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public ProductListingPage navigateToHomepage(){
        String applicationURL = "https://spree-vapasi.herokuapp.com";
        driver.navigate().to(applicationURL);
        return new ProductListingPage(driver);
    }
}
