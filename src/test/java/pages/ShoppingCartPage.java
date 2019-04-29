package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

public class ShoppingCartPage {
    WebDriver driver;

    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isProductInCart(String productName) {
        if (driver.findElement(By.id("cart-detail")).findElement(By.linkText(productName)).isDisplayed())
            return true;

        return false;
    }

    public String getQuantityForProductIncart(String productName) {

        List<WebElement> cartProducts = driver.findElement(By.id("cart-detail")).findElements(By.className("line-item"));

        for (Iterator<WebElement> productIterator = cartProducts.iterator(); productIterator.hasNext(); ) {

            WebElement product = productIterator.next();
            String prodDesc = product.findElement(By.className("cart-item-description")).getText();

            if (prodDesc.contains(productName)) {
                System.out.println("Quantity is " + product.findElement(By.className("cart-item-quantity")).findElement(By.tagName("input")).getAttribute("value"));
                String quantityActual = product.findElement(By.className("cart-item-quantity")).findElement(By.tagName("input")).getAttribute("value");
                return quantityActual;
            }
        }

        return "0";
    }

    public int getNumberOfProductsInCart() {

        List<WebElement> cartProducts = driver.findElement(By.id("cart-detail")).findElements(By.className("line-item"));
        System.out.println("Number of products :"+ cartProducts.size());
        return cartProducts.size();
    }
}
