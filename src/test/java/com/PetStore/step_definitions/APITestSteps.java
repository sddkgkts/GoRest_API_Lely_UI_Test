package com.PetStore.step_definitions;

import com.PetStore.Pojo.Category;
import com.PetStore.Pojo.PetPojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class APITestSteps {
PetPojo petPojo = new PetPojo();
Category category = new Category();


    @Given("User Create a new pet on petStore successfully")
    public void user_create_a_new_pet_on_pet_store_successfully() {
        petPojo.setId(44);
        category.setId(1);
        category.setName("Kangal");
        petPojo.setCategory(category);
        petPojo.setStatus("Available");

        Response response = given().log().all()
                .accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(petPojo)
                .when()
                .post(baseURI+"/pet");
        System.out.println("============POST=============");
        response.prettyPrint();
        System.out.println("=========================");
        //verify status code 201 for post
        assertEquals(response.statusCode(),200);
        //verify content type
        assertEquals(response.contentType(),"application/json");
    }
    @When("User Retrieve created pet from petStore successfully")
    public void user_retrieve_created_pet_from_pet_store_successfully() {
        Response response = given().log().all()
                .accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .when()
                .get(baseURI+"/pet/44");
        System.out.println("============GET=============");
        response.prettyPrint();

        //verify status code 200 for post
        assertEquals(response.statusCode(),200);
    }
    @Then("User Update pets name successfully")
    public void user_update_pets_name_successfully() {
        petPojo.setName("KucuKucu");
        Response response = given().log().all()
                .accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(petPojo)
                .when()
                .put(baseURI+"/pet");
        System.out.println("============PUT-UPDATE=============");
        response.prettyPrint();
        System.out.println("=========================");
        //verify status code 200 for put
        assertEquals(response.statusCode(),200);

        //verify content type
        assertEquals(response.contentType(),"application/json");
    }
    @Then("User Delete created pet from petStore successfully")
    public void user_delete_created_pet_from_pet_store_successfully() {
                given()
                .accept(ContentType.JSON)
                .when()
                .delete(baseURI+"/pet/44")
                .then()
                .statusCode(200).log().all();

    }
    @Given("User Retrieve pet from petStore with invalid ID")
    public void user_retrieve_pet_from_pet_store_with_invalid_id() {
        Response response = given().log().all()
                .accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .when()
                .get(baseURI+"/pet/44");
        System.out.println("============GET=============");
        response.prettyPrint();

        //verify status code 200 for post
        assertEquals(response.statusCode(),404);
    }
    @Then("User Delete pet from petStore with invalid ID")
    public void user_delete_pet_from_pet_store_with_invalid_id() {
        given()
                .accept(ContentType.JSON)
                .when()
                .delete(baseURI+"/pet/44")
                .then()
                .statusCode(404).log().all();
    }



}
