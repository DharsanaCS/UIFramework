package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {

    WebDriver driver;

    public ProductDetailsPage(WebDriver driver){
        this.driver = driver;
    }

    public void addProductToCart(String quantity) {


        driver.findElement(By.id("quantity")).clear();
        driver.findElement(By.id("quantity")).sendKeys(quantity);
        driver.findElement(By.id("add-to-cart-button")).click();
    }


}
