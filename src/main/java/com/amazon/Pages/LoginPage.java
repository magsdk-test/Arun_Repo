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

    public void loginIntoAmazon(String email, String pass) throws InterruptedException {
        userEmail.sendKeys(email);
        continueLogin.click();
        userPass.sendKeys(pass);
        submitLogin.click();
        if (captchaAuth.size()> 1){
            userPass.sendKeys(pass);
            System.out.println("The Captcha can not be automated. It is one of the limitation of selenium");
            System.out.println("It needs to be handled manually.");
            System.out.println("-----****---Please enter the shown captcha---****-----");
            Thread.sleep(15000);
        }
        else
        {
            System.out.println("The captcha is not shown. Continuing Automated test..");
        }        
    }
}
