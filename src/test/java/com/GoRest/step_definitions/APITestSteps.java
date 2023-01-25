package com.GoRest.step_definitions;

import java.lang.Integer;

import com.GoRest.Pojo.Datum;
import com.GoRest.Pojo.GoRestPojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class APITestSteps {
int id;
    @Given("As a user I should get all of the data id values are four digit integers and none of them are null")
    public void Check_that_all_of_the_data_id_values_are_four_digit_integers_and_none_of_them_are_null() {

        Response response = given()
                .accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .when()
                .get(baseURI);
        assertEquals(response.statusCode(), 200);
        //verify content type
        assertEquals("application/json; charset=utf-8", response.contentType());
        GoRestPojo goRest = response.body().as(GoRestPojo.class);
        List<Datum> datumList = goRest.getData();

        for (Datum datum : datumList
        ) {
            assertNotNull(datum.getId());
            assertTrue(datum.getId() instanceof Integer);
            assertTrue(datum.getId().toString().matches("[0-9]{4}"));
        }
    }

    @When("As a user I should create a data with given info")
    public void user_should_create_a_data_with_given_info() {
        Datum data = new Datum();
        data.setEmail("umut20@gmail.com");
        data.setName("test");
        data.setGender("male");
        data.setStatus("active");


        String accessToken = "Bearer 1db9c9b6c959682be7c96f74ca532c3cb0bd331f46b86a92602f8d319481b6f5";
        Response response = given()
                .accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .when()
                .header("Authorization", accessToken)
                .body(data)
                .post(baseURI);

        JsonPath responseJsonPath = response.jsonPath();
        id = responseJsonPath.get("data.id");
        assertEquals(201, response.statusCode());
    }

    @Then("As a user I should not create a data with used info")
    public void User_should_not_create_a_data_with_used_info() {

        Datum data = new Datum();
        data.setEmail("umut20@gmail.com");
        data.setName("test");
        data.setGender("male");
        data.setStatus("active");


        String accessToken = "Bearer 1db9c9b6c959682be7c96f74ca532c3cb0bd331f46b86a92602f8d319481b6f5";
        Response response = given()
                .accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .when()
                .header("Authorization", accessToken)
                .body(data)
                .post(baseURI);


        JsonPath responseJsonPath = response.jsonPath();
        Assert.assertEquals("has already been taken", responseJsonPath.get("data[0].message"));

        Response response1 = given()
                .accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .when()
                .header("Authorization", accessToken)
                .delete(baseURI+"/"+id);
        assertEquals(204,response1.statusCode());


    }


}


// 18 -"id": 184854