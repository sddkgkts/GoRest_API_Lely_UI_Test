package com.GoRest.utilities;

import com.GoRest.Pages.SearchPage;
import org.openqa.selenium.WebElement;

public class Tools {

    public static boolean contains(String searchedKey) {
        boolean containSearchKey = true;
        SearchPage searchPage = new SearchPage();
        for (int i=0; i<searchPage.findPageNumbers()-1; ++i) {
            searchPage.goToPage((i+1)).click();
            for (WebElement item : searchPage.findSearchItems()) {
                containSearchKey = item.getText().toLowerCase().contains(searchedKey);
                if (!containSearchKey) {
                    break;
                }
            }
        }

        return containSearchKey;
    }
}