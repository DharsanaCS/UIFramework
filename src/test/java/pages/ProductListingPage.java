package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductListingPage {

    WebDriver driver;


    public ProductListingPage(WebDriver driver){
        this.driver = driver;
    }

    public ProductDetailsPage selectProduct(String category, final String product) {

        driver.findElement(By.linkText(category)).click();
        driver.findElement(By.xpath("//img[@alt='" + product + "']")).click();
        return new ProductDetailsPage(driver);

    }
}
