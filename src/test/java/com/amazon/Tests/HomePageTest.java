package com.amazon.Tests;

import com.amazon.Pages.CartPage;
import com.amazon.Pages.HomePage;
import com.amazon.Pages.LoginPage;
import com.amazon.Pages.SearchResultPage;
import com.amazon.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
	HomePage homePage;
	SearchResultPage searchResultPage;
	CartPage cartPage;
	LoginPage loginPage;

	public HomePageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
	}

	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		homePage = new HomePage();
		String homePageActualTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageActualTitle, prop.getProperty("homePageExpectedTitle"),"Home page title not matched");
	}

	@Test(priority=2, invocationCount = 1)
	@Parameters({"email", "password"})
	public void verifySearchBox(String email, String password) throws InterruptedException{
		homePage = new HomePage();
		searchResultPage = new SearchResultPage();
		cartPage = new CartPage();
		loginPage = new LoginPage();
		Assert.assertTrue(homePage.verifySearchBox());
		homePage.searchItem();
		searchResultPage.selectFirstItem();
		Assert.assertTrue(cartPage.isAddToCartBtnDisplayed(),"The Add to cart & Buy Now options are not displayed");
		Assert.assertTrue(cartPage.isBuyNowBtnDisplayed(),"The Add to cart & Buy Now options are not displayed");
		cartPage.addToCart();
		Assert.assertEquals(cartPage.isItemAddedToCart(),"Added to Cart", "The Item is not added to cart");
		cartPage.proceedToCheckout();
		loginPage.loginIntoAmazon(email,password);
		Assert.assertTrue(homePage.verifyAddrsPageElement());
		Assert.assertTrue(homePage.verifyAddrssPageTitle().contains(prop.getProperty("AddressPageTitle")));
		Assert.assertTrue(homePage.verifyAddrssPageUrl().contains(prop.getProperty("AddressPageURL")));
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
