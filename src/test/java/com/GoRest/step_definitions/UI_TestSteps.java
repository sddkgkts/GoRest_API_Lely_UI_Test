package com.GoRest.step_definitions;

import com.GoRest.Pages.HomePage;
import com.GoRest.Pages.TechnicalDocumentsPage;
import com.GoRest.utilities.BrowserUtils;
import com.GoRest.utilities.ConfigurationReader;
import com.GoRest.utilities.Driver;
import com.GoRest.utilities.Tools;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.io.IOException;
import static org.junit.Assert.assertTrue;



public class UI_TestSteps {
    HomePage homePage = new HomePage();
    TechnicalDocumentsPage technicalDocumentsPage = new TechnicalDocumentsPage();

    @Given("As a user I should Navigate to url")
    public void as_a_user_i_should_navigate_to_url() {
        String url = ConfigurationReader.get("lely_URL");
        Driver.get().get(url);
        homePage.acceptCookieButton.click();
        BrowserUtils.waitForVisibility(homePage.pageLogo, 10);
        homePage.pageLogo.isDisplayed();
    }

    @Given("As a user I should click search button and verify search area appeared.")
    public void as_a_user_i_should_click_search_button_and_verify_search_area_appeared() {
        homePage.searchSymbol.click();
        BrowserUtils.waitForVisibility(homePage.searchButton, 5);
        homePage.searchButton.isEnabled();
    }

    @When("As a user I should enter {string} into the search area and click the search button")
    public void asAUserIShouldEnterIntoTheSearchAreaAndClickTheSearchButton(String searchKey) {
        BrowserUtils.waitForVisibility(homePage.searchBar, 5);
        homePage.searchBar.sendKeys(searchKey);
        homePage.searchButton.click();
    }

    @Then("As a user I should verify that the descriptions of each of the search results contain the {string} word.")
    public void asAUserIShouldVerifyThatTheDescriptionsOfEachOfTheSearchResultsContainTheWord(String searchKey) {
        assertTrue(Tools.contains(searchKey));
    }


    @Given("As a user I should navigate to Technical Documents")
    public void asAUserIShouldNavigateToTechnicalDocuments() {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(homePage.maintenanceMenu).perform();
        BrowserUtils.waitForVisibility(homePage.tecnicalDocuments, 5);
        homePage.tecnicalDocuments.click();

    }

    @When("As a user I should select LUNA EUR from the dropdown and verify that the catalogs can be seen")
    public void asAUserIShouldSelectLUNAEURFromTheDropdownAndVerifyThatTheCatalogsCanBeSeen() {
        technicalDocumentsPage.dropDownBox.click();
        technicalDocumentsPage.dropDownSearchBox.sendKeys("Luna Eur" + Keys.ENTER);
    }

    @Then("As a user I should view the document and verify that it is opened on a new tab")
    public void asAUserIShouldViewTheDocumentAndVerifyThatItIsOpenedOnANewTab() {

        for (WebElement viewDoc : technicalDocumentsPage.viewThisDocs()) {
            viewDoc.click();
        }
        for (String newWindow : BrowserUtils.isNewWindowOpen()) {
            assertTrue(newWindow.contains("name=D-S"));
        }
    }

    @And("As a user I should return to the previous tab and download the document. Verify that it is downloaded")
    public void asAUserIShouldReturnToThePreviousTabAndDownloadTheDocumentVerifyThatItIsDownloaded() throws IOException {
        System.out.println("BrowserUtils.getNumberOfFiles() = " + BrowserUtils.getNumberOfFiles());
        BrowserUtils.cleanFolder();
        for (WebElement downloadDoc : technicalDocumentsPage.downloadLinks()) {
            downloadDoc.click();
            BrowserUtils.waitFor(3);
        }

        System.out.println("BrowserUtils.getNumberOfFiles() = " + BrowserUtils.getNumberOfFiles());
        assertTrue(BrowserUtils.getNumberOfFiles() > 0);
        BrowserUtils.cleanFolder();

    }
}
