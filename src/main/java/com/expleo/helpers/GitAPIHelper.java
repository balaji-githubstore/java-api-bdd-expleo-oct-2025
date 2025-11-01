package com.expleo.helpers;

import com.expleo.model.Repository;
import com.expleo.utils.GitRequestSpecBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.assertj.core.api.BDDAssumptions;




public class GitAPIHelper {

    public static Response ListRepositoriesForAuthenticatedUser()
    {

        Response response= RestAssured
                .given()
                .spec(GitRequestSpecBuilder.getGitRequestSpec())
                .when()
                .get("/user/repos");

        return response;
    }

    public static Response CreateRepository(Repository repo)
    {
        return RestAssured
                .given()
                .spec(GitRequestSpecBuilder.getGitRequestSpec())
                .body(repo)
                .when()
                .post("/user/repos");
    }

    public static Response DeleteRepository(String owner,String repositoryName)
    {
        return RestAssured
                .given()
                .spec(GitRequestSpecBuilder.getGitRequestSpec())
                .pathParams("owner",owner)
                .pathParams("repo",repositoryName)
                .when()
                .delete("/repos/{owner}/{repo}");
    }
}
