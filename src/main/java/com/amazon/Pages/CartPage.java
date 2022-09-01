package com.amazon.Pages;

import com.amazon.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends TestBase {

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement addToCart;

    @FindBy(xpath = "//input[@value='Proceed to checkout']")
    private WebElement proceedToCheckoutBtn;

    @FindBy(xpath = "//*[@id='sw-atc-details-single-container']/div[2]/div/span")
    private WebElement addedToCart;

    // Initializing the Page Objects:
    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isAddToCartBtnDisplayed(){
        return addToCart.isDisplayed();
    }

    public boolean isBuyNowBtnDisplayed(){
        return addToCart.isDisplayed();
    }

    public void addToCart(){
        addToCart.click();
    }

    public String isItemAddedToCart(){
        return addedToCart.getText();
    }
    
    public void proceedToCheckout(){
        proceedToCheckoutBtn.click();
    }
}
