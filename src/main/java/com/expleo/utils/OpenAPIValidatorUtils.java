package com.expleo.utils;

import com.atlassian.oai.validator.restassured.OpenApiValidationFilter;
import com.expleo.config.ConfigReader;

public class OpenAPIValidatorUtils {
    private static OpenApiValidationFilter validationFilter;


    public static OpenApiValidationFilter getValidationFilter() {
        if (validationFilter == null) {
            validationFilter = new OpenApiValidationFilter(ConfigReader.getOpenAPISpec());
        }
        return validationFilter;
    }
}
