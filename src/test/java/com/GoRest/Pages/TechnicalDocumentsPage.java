package com.GoRest.Pages;

import com.GoRest.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TechnicalDocumentsPage extends BasePage {

    @FindBy(xpath = "//span[@class='select2-selection__rendered']")
    public WebElement dropDownBox;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement dropDownSearchBox;

    public List<WebElement> viewThisDocs() {
        List<WebElement> viewDocs = Driver.get().findElements(By.xpath("//a[contains(text(),'View this document')]"));
        return viewDocs;
    }

    public List<WebElement> downloadLinks() {
        List<WebElement> downloadDocs = Driver.get().findElements(By.xpath("//a[contains(text(),'Download')]"));
        return downloadDocs;
    }


}
