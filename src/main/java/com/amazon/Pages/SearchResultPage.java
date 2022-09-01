package com.amazon.Pages;

import com.amazon.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage extends TestBase {

    @FindBy(xpath = ".//span[@class='a-size-medium a-color-base a-text-normal']")
    List<WebElement> searchedItem;

    // Initializing the Page Objects:
    public SearchResultPage() {
        PageFactory.initElements(driver, this);
    }

    public void selectFirstItem() {
        int size = searchedItem.size();
        System.out.println("Size of list = " + size);
        searchedItem.get(0).click();
    }
}
