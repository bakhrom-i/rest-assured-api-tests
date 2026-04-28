package com.portfolio.api.clients;

import com.portfolio.api.config.Config;
import io.restassured.response.Response;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthClient {

    public Response login(String user, String pwd) {
        return given()
                .baseUri(Config.baseUrl())
                .contentType("application/json")
                .body(Map.of("email", user, "password", pwd))
                .when()
                .post("/auth/login");
    }

    public String token() {
        return login(Config.authUser(), Config.authPwd())
                .then().statusCode(200)
                .extract().path("token");
    }
}
