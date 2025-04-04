package config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationConfig {
    private static final String BASE_URL = "http://localhost:8080/";

    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType(io.restassured.http.ContentType.JSON)
                .addHeader("Accept", "application/json")
                .build();
    }
}