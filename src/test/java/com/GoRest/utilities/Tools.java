package com.GoRest.utilities;

import com.GoRest.Pages.SearchPage;
import org.openqa.selenium.WebElement;

public class Tools {

    public static boolean contains(String searchedKey) {
        boolean containSearchKey = true;
        SearchPage searchPage = new SearchPage();
        do {
            for (WebElement item : searchPage.findSearchItems()) {
                containSearchKey = item.getText().toLowerCase().contains(searchedKey);
                if (containSearchKey == false) {
                    break;
                }
            }
            if (searchPage.nextButton.isEnabled()) {
                searchPage.nextButton.click();
            }

        } while (searchPage.nextButton.isEnabled() && containSearchKey == true);
        return containSearchKey;
    }


}