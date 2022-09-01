package com.amazon.Pages;

import com.amazon.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends TestBase {
	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchBox;

	@FindBy(id = "nav-search-submit-button")
	private WebElement searchBtn;

	@FindBy(xpath = "//div[@id='addres-new']")
	private WebElement addressForm;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		System.out.println("The Actual title is: "+ driver.getTitle());
		return driver.getTitle();
	}

	public boolean verifySearchBox(){
		return searchBox.isDisplayed();
	}

	public void searchItem(){
		searchBox.sendKeys("Sony TV");
		searchBtn.click();
	}

	public boolean verifyAddrsPageElement(){
		return addressForm.isDisplayed();
	}

	public String verifyAddrssPageUrl(){
		System.out.println("The title name is: "+ driver.getTitle());
		return driver.getCurrentUrl();
	}

	public String verifyAddrssPageTitle(){
		System.out.println("The title name is: "+ driver.getTitle());
		return driver.getTitle();
	}
}
