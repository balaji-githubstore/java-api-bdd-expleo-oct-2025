package com.expleo.helpers;

import com.expleo.model.Repository;
import com.expleo.utils.GitRequestSpecBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.assertj.core.api.BDDAssumptions;

import java.util.List;


public class GitAPIHelper {

    public static Response listRepositoriesForAuthenticatedUser() {

        Response response = RestAssured
                .given()
                .spec(GitRequestSpecBuilder.getGitRequestSpec())
                .when()
                .get("/user/repos");

        return response;
    }

    public static Response createRepository(Repository repo) {
        return RestAssured
                .given()
                .spec(GitRequestSpecBuilder.getGitRequestSpecWithoutValidation())
                .body(repo)
                .when()
                .post("/user/repos");
    }

    public static Response deleteRepository(String owner, String repositoryName) {
        return RestAssured
                .given()
                .spec(GitRequestSpecBuilder.getGitRequestSpecWithoutValidation())
                .pathParams("owner", owner)
                .pathParams("repo", repositoryName)
                .when()
                .delete("/repos/{owner}/{repo}");
    }

    public static <T> T deserializeResponseToPojoClass(Response response, Class<T> classType) {
        return response.as(classType);
    }

    public static <T> List<T> deserializeResponseToListOfPojoClass(Response response, Class<T> classType) {
        return response.jsonPath().getList(".", classType);
    }


}
