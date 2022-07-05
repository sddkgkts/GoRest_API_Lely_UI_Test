package com.PetStore.step_definitions;

import com.PetStore.utilities.ConfigurationReader;
import io.cucumber.java.Before;
import static io.restassured.RestAssured.baseURI;


public class Hooks {

	@Before("@WIP")
	public void before() {
		baseURI= ConfigurationReader.get("petStore.apiUrl");

	}

}
