package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class test_post_request {
    private static final String base_url = "https://reqres.in/api";
    private static final String end_point = "/users";

    @Test
    public void testPostRequest() {
        String requestBody = "{\"name\": \"Tanvir\", \"job\": \"SQA Engineer\"}";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(base_url + end_point);
        
        int statusCode = response.getStatusCode();
        System.out.println("Status code: " + statusCode);
        Assert.assertEquals(statusCode, 201);
        System.out.println("\n");
        
        System.out.println("Response JSON:");
        response.prettyPrint();
        System.out.println("\n");

        System.out.println("Plain Text:");
        System.out.println("name: " + response.path("name"));
        System.out.println("job: " + response.path("job"));
        System.out.println("id: " + response.path("id"));
        System.out.println("createdAt: " + response.path("createdAt"));
    }
}
