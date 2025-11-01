package com.expleo.helpers.mock;

import com.expleo.helpers.GitAPIHelper;
import com.expleo.model.Repository;
import io.restassured.builder.ResponseBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.parser.OpenAPIV3Parser;

import java.nio.file.Paths;

public class OpenApiMockResponse {

    public static Response getMockResponse(OpenAPI openAPI, String path, String method, String statusCode) {
        ApiResponse apiResponse = openAPI.getPaths()
                .get(path)
                .getPost()  // since we're mocking POST; could add switch for other methods
                .getResponses()
                .get(statusCode);

        Content content = apiResponse.getContent();
        if (content == null) throw new RuntimeException("No content found for status " + statusCode);

        MediaType mediaType = content.get("application/json");
        if (mediaType == null || mediaType.getExample() == null)
            throw new RuntimeException("No example found for status " + statusCode);

        Object example = mediaType.getExample();

        // Build Rest Assured mock response
        return new ResponseBuilder()
                .setStatusCode(Integer.parseInt(statusCode))
                .setContentType("application/json")
                .setBody(JsonPath.given(example.toString()).prettify())
                .build();
    }

    public static void main(String[] args) {
        // Load and parse OpenAPI spec
        OpenAPI openAPI = new OpenAPIV3Parser().read(Paths.get("src/test/resources/schema/gitrepo.yaml").toAbsolutePath().toString());

        // Example: Get mock response for POST /user/repos  -> 201
        Response successResponse = getMockResponse(openAPI, "/user/repos", "post", "201");
        successResponse.prettyPrint();

        Repository responseToPojoClass= GitAPIHelper.deserializeResponseToPojoClass(successResponse, Repository.class);


        Response errorResponse = getMockResponse(openAPI, "/user/repos", "post", "401");
        errorResponse.prettyPrint();
    }

}
