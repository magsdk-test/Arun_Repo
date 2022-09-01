package com.amazon.Pages;

import com.amazon.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement userEmail;

    @FindBy(xpath = "//input[@id='ap_password']")
    private WebElement userPass;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    private WebElement submitLogin;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueLogin;

    // Initializing the Page Objects:
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginIntoAmazon(String email, String pass){
        userEmail.sendKeys(email);
        continueLogin.click();
        userPass.sendKeys(pass);
        submitLogin.click();
    }
}
