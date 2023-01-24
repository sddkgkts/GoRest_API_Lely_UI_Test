package com.GoRest.Pages;

import com.GoRest.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {


    @FindBy(xpath = "//*[contains(text(), 'Next')]")
    public WebElement nextButton;

    public List<WebElement> findSearchItems() {
        List<WebElement> searchItems = Driver.get().findElements(By.xpath("//section[@class='item-section']"));
        return searchItems;
    }


}
