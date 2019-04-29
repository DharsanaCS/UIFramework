package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductListingPage;
import pages.ShoppingCartPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddToCartTest extends BaseTest{

    @Test
    public void testAddToCart(){


        String category = "Bags";
        String productName = "Ruby on Rails Bag";
        String quantity = "3";
        int numberOfProductsInCart = 1;

        LoginPage loginPage = new LoginPage(driver);

        ShoppingCartPage scPage = loginPage.login("spree@example.com","spree123").selectProduct(category, productName).addProductToCart(quantity);

        Map<String,String> productDetails = scPage.getProductDetailsInCart();
        assertTrue(productDetails.containsKey(productName), "Product"+productName+"not added to cart");
        assertEquals(productDetails.size(),numberOfProductsInCart);
        assertEquals(productDetails.get(productName),quantity);
/*
        ProductListingPage plPage = new ProductListingPage(driver);
        plPage.selectProduct(category, productName);

        ProductDetailsPage pdPage = new ProductDetailsPage(driver);
        pdPage.addProductToCart(quantity);

        ShoppingCartPage scPage = new ShoppingCartPage(driver);
*/
/*
        assertTrue(scPage.isProductInCart(productName), "Product"+productName+"not added to cart");
        assertEquals(scPage.getNumberOfProductsInCart(),numberOfProductsInCart);
        assertEquals(scPage.getQuantityForProductIncart(productName),quantity);
*/
    }


}
