package com.GoRest.Pages;

import com.GoRest.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {


    @FindBy(xpath = "//a[contains(@class, 'page-link') and contains(., 'Next')]")
    public WebElement nextButton;

    @FindBy(xpath = "//span[contains(@class, 'page-link disabled') and contains(., 'Next')]")
    public WebElement nextButtonDisable;

    public List<WebElement> findSearchItems() {
        List<WebElement> searchItems = Driver.get().findElements(By.xpath("//section[@class='item-section']"));
        return searchItems;
    }

    public Integer findPageNumbers() {
        List<WebElement> pageNumber = Driver.get().findElements(By.xpath("//li[@class='page']"));
        int i = pageNumber.size();
        Integer pageNum = Integer.valueOf(pageNumber.get((i-1)).getText());
        return pageNum;
    }

    public WebElement  goToPage(int i) {
        return Driver.get().findElement(By.xpath("//li[contains(@class, 'page') and contains(.,'"+i+"' )]"));
    }


}
