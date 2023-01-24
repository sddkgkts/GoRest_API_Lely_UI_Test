package com.GoRest.step_definitions;

import com.GoRest.utilities.ConfigurationReader;
import com.GoRest.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.baseURI;


public class Hooks {

    @Before("@API_TEST")
    public void before() {
        baseURI = ConfigurationReader.get("goRest.apiUrl");

    }

    @Before("@UI_TEST")
    public void setUp() {
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Driver.get().manage().window().maximize();
    }

    @After("@UI_TEST")
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }

        Driver.closeDriver();

    }

}
