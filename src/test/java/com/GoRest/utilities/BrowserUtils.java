package com.GoRest.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class BrowserUtils {

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static List<String> isNewWindowOpen() {
        List<String> windowsUrl = new ArrayList<>();
        String currentHandle = Driver.get().getWindowHandle();
        Set<String> allHandles = Driver.get().getWindowHandles();

        for (String eachHandle : allHandles) {
            if (!(eachHandle.equals(currentHandle))) {
                Driver.get().switchTo().window(eachHandle);
                windowsUrl.add(Driver.get().getCurrentUrl());
            }
        }
        Driver.get().switchTo().window(currentHandle);
        return windowsUrl;
    }

    public static File getLatestFileFromDir(String downloadPath) {
        File dir = new File(downloadPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }

        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        return lastModifiedFile;
    }

    public static void cleanFolder(){
        File folder = new File(System.getProperty("user.dir") + "/src/test/java/com/GoRest/Download");
        File[] files = folder.listFiles();
        for (File file : files) {
            file.delete();
        }
    }

    public static int getNumberOfFiles(){
        File folder = new File(System.getProperty("user.dir") + "/src/test/java/com/GoRest/Download");
        File[] files = folder.listFiles();

        return files.length;

    }


}
