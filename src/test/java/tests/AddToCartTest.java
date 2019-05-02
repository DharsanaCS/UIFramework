package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddToCartTest extends BaseTest{

    @Test(dataProvider = "getProductsToAdd")
    public void testAddToCart(String category, String productName, String quantity) {


        int numberOfProductsInCart = 1;
        HomePage homePage = new HomePage(driver);
        ShoppingCartPage scPage = homePage.navigateToHomepage()
                .selectProduct(category, productName)
                .addProductToCart(quantity);

        Reporter.log("Added product to cart",true);

        //getProductDetailsInCart returns a map with key being the product name and value being the quantity
        Map<String, String> productDetails = scPage.getProductDetailsInCart();
        assertTrue(productDetails.containsKey(productName), "Product" + productName + "not added to cart");
        assertEquals(productDetails.size(), numberOfProductsInCart);
        assertEquals(productDetails.get(productName), quantity);
    }
    @DataProvider(name="getProductsToAdd")
    public Object[][] getProductsToAdd(){
        return new Object[][]
                {
                        {"Bags", "Ruby on Rails Bag", "3"},
                        {"Mugs", "Ruby on Rails Mug", "2"},
                        {"Clothing", "Apache Baseball Jersey", "1"},
                };
    }
}
