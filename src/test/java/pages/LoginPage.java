package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "link-to-login")
    private WebElement login_button;

    @FindBy(id = "spree_user_email")
    private WebElement email_textbox;

    @FindBy(id = "spree_user_password")
    private WebElement password_textbox;

    @FindBy(name = "commit")
    private WebElement submit_button;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ProductListingPage login(String userName, String password) {

        login_button.click();
        email_textbox.sendKeys(userName);
        password_textbox.sendKeys(password);
        submit_button.click();
        return new ProductListingPage(driver);
    }


    }


