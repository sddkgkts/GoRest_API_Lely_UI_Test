package com.GoRest.Pages;

import com.GoRest.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "a[title=\"Go to home page\"]")
    public WebElement pageLogo;

    @FindBy(id = "cookienotice-button-accept")
    public WebElement acceptCookieButton;

    @FindBy(xpath = "//a[.='Maintenance']")
    public WebElement maintenanceMenu;

    @FindBy(xpath = "(//a[contains(text(),'Technical documents')])[1]")
    public WebElement tecnicalDocuments;


}
