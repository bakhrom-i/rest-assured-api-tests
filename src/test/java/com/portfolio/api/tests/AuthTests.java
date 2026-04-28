package com.portfolio.api.tests;

import com.portfolio.api.clients.AuthClient;
import com.portfolio.api.config.Config;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class AuthTests {

    private final AuthClient auth = new AuthClient();

    @Test(groups = "auth")
    public void login_returns_token_and_matches_schema() {
        auth.login(Config.authUser(), Config.authPwd())
            .then()
            .statusCode(200)
            .body("token", not(emptyString()))
            .body(matchesJsonSchemaInClasspath("schemas/login.json"));
    }

    @DataProvider(name = "invalidCreds")
    public Object[][] invalidCreds() {
        return new Object[][] {
            {"wrong@example.com", "test"},
            {Config.authUser(),   "wrong"},
            {"",                  ""}
        };
    }

    @Test(groups = "auth", dataProvider = "invalidCreds")
    public void login_with_invalid_creds_returns_401(String user, String pwd) {
        auth.login(user, pwd)
            .then()
            .statusCode(anyOf(is(400), is(401)));
    }
}
