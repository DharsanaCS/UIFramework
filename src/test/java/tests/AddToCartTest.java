package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddToCartTest extends BaseTest{

    @Test
    public void testAddToCart(){

        String applicationURL = "https://spree-vapasi.herokuapp.com";
        String category = "Bags";
        String productName = "Ruby on Rails Bag";
        String quantity = "3";
        int numberOfProductsInCart = 1;

        driver.navigate().to(applicationURL);

        addProductToCart(category, productName, quantity);

        assertTrue(isProductInCart(productName), "Product"+productName+"not added to cart");
        assertEquals(getNumberOfProductsInCart(),numberOfProductsInCart);
        assertEquals(getQuantityForProductIncart(productName),quantity);

    }


    private void addProductToCart(String category, final String product, String quantity) {

        driver.findElement(By.linkText(category)).click();
        driver.findElement(By.xpath("//img[@alt='" + product + "']")).click();
        driver.findElement(By.id("quantity")).clear();
        driver.findElement(By.id("quantity")).sendKeys(quantity);
        driver.findElement(By.id("add-to-cart-button")).click();
    }


    private boolean isProductInCart(String productName) {
        if (driver.findElement(By.id("cart-detail")).findElement(By.linkText(productName)).isDisplayed())
            return true;

        return false;
    }

    private String getQuantityForProductIncart(String productName) {

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

    private int getNumberOfProductsInCart() {

        List<WebElement> cartProducts = driver.findElement(By.id("cart-detail")).findElements(By.className("line-item"));
        System.out.println("Number of products :"+ cartProducts.size());
        return cartProducts.size();
    }

}
