package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.ProductListingPage;
import pages.ShoppingCartPage;

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

        ProductListingPage plPage = new ProductListingPage(driver);
        plPage.selectProduct(category, productName);

        ProductDetailsPage pdPage = new ProductDetailsPage(driver);
        pdPage.addProductToCart(quantity);

        ShoppingCartPage scPage = new ShoppingCartPage(driver);

        assertTrue(scPage.isProductInCart(productName), "Product"+productName+"not added to cart");
        assertEquals(scPage.getNumberOfProductsInCart(),numberOfProductsInCart);
        assertEquals(scPage.getQuantityForProductIncart(productName),quantity);

    }


}
