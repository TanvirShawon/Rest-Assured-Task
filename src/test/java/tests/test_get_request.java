package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

public class test_get_request {
   
    private static final String base_url = "https://reqres.in/api";
    private static final String end_point = "/users";
    @Test
    public void testGetRequest() {
        Response response = given().when().get(base_url + end_point);

        int statusCode = response.getStatusCode();
        System.out.println("Status code: " + statusCode);
        Assert.assertEquals(statusCode, 200);
        
        System.out.println("Response in JSON:\n");
        response.prettyPrint();
        
        System.out.println("\n");

        System.out.println("Plain Text:\n");
        System.out.println("page: " + response.jsonPath().get("page"));
        System.out.println("per_Page: " + response.jsonPath().get("per_page"));
        System.out.println("total: " + response.jsonPath().get("total"));
        System.out.println("total_Pages: " + response.jsonPath().get("total_pages"));
        System.out.println("data:");
        response.jsonPath().getList("data").forEach(data -> {
            System.out.println("id: " + ((HashMap<String, Object>) data).get("id"));
            System.out.println("email: " + ((HashMap<String, Object>) data).get("email"));
            System.out.println("first_name: " + ((HashMap<String, Object>) data).get("first_name"));
            System.out.println("last_name: " + ((HashMap<String, Object>) data).get("last_name"));
            System.out.println("avatar: " + ((HashMap<String, Object>) data).get("avatar"));
            System.out.println();
        });
        
    }
}