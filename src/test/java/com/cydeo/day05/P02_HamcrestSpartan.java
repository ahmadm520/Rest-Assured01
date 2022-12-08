package com.cydeo.day05;

import com.cydeo.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class P02_HamcrestSpartan extends SpartanTestBase {

    /*
    Given accept type is Json
    And path param id is 15
    When user sends a get request to spartans/{id}
    Then status code is 200
    And content type is Json
    And json data has following
        "id": 15,
        "name": "Meta",
        "gender": "Female",
        "phone": 1938695106
     */


    @DisplayName("Get Single Spartan with Hamcrest")
    @Test
    public void test1() {

        given().accept(ContentType.JSON)
                .and()
                .pathParam("id",15).
        when().get("/api/spartans/{id}").
        then().log().ifValidationFails()
                .assertThat()
                .statusCode(200)
                .assertThat()
                .and() // these are filler keywords / syntatic sugar to increase readability
                // .statusCode(is(200)) --> if you wanna use with Matchers method you can use to increase readability
                .contentType("application/json")
                .assertThat() // these are again syntatic sugar just to increase readability
                .and()
                .body("id",is(15),
                             "name",is("Meta"),
                             "gender",is("Female"),
                              "phone",is(1938695106));

        /*
        REQUEST
            given().log().all() --> it will give all inforamtion anout your request (path/query params , URI , body etc )
                  .method()
                  .uri()
                  .parameters() ......
        RESPONSE

             then().log().all() --> it will give all response information
                         .ifValidationFails() --> it will print all response if one of the validation fails

         */

    }
}
