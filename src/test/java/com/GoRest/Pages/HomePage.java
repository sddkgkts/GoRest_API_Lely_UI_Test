package com.GoRest.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[text()='Search']")
    public WebElement searchSymbol;

    @FindBy(css = "input[type=\"text\"]")
    public WebElement searchBar;

    @FindBy(css = "button[class=\"button button-tertiary\"]")
    public WebElement searchButton;


}
