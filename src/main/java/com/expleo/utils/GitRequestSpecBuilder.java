package com.expleo.utils;


import com.expleo.config.ConfigReader;
import com.expleo.config.TokenManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class GitRequestSpecBuilder {

    public static RequestSpecification getGitRequestSpec() {

        return new RequestSpecBuilder()
                .setBaseUri(ConfigReader
                        .getBaseURI())
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", TokenManager.getToken())
                .addFilter(OpenAPIValidatorUtils.getValidationFilter())
                .log(LogDetail.ALL)
                .build();

    }

    public static RequestSpecification getGitRequestSpecWithoutValidation() {

        return new RequestSpecBuilder()
                .setBaseUri(ConfigReader
                        .getBaseURI())
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", TokenManager.getToken())
                .log(LogDetail.ALL)
                .build();
    }
}
