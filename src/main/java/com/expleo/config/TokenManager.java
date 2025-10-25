package com.expleo.config;

import io.restassured.path.json.JsonPath;

import java.io.FileInputStream;

public class TokenManager {
    private static String TOKEN_PATH="src/test/resources/secret.json";
    private static String token;

    public static String getToken() {
        FileInputStream file = null;

        try {
            if(token==null)
            {
                file = new FileInputStream(TOKEN_PATH);
                JsonPath jsonPath = new JsonPath(file);
                token = jsonPath.get("token");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return token;
    }
}
