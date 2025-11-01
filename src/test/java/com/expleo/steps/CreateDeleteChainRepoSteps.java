package com.expleo.steps;

import com.expleo.context.TestContext;
import com.expleo.helpers.GitAPIHelper;
import com.expleo.model.Repository;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

public class CreateDeleteChainRepoSteps {

    private final TestContext context;

    public CreateDeleteChainRepoSteps(TestContext context)
    {
        this.context=context;
    }

    @When("I create a new repository with name as {string}")
    public void i_create_a_new_repository_with_name_as(String repoName) {
        Response response= GitAPIHelper.createRepository(Repository.builder().name(repoName).build());
        //load the respone to TestContext class object
        context.setResponse(response);

        context.setTestData("repositoryName",repoName);
    }
    @When("I delete the same repository for owner {string}")
    public void i_delete_the_same_repository_for_owner(String owner) {

        Response response= GitAPIHelper.deleteRepository(owner,context.getTestDataAsString("repositoryName"));
        context.setResponse(response);
    }

    @When("I create a new repository")
    public void i_create_a_new_repository(DataTable dataTable) {

        List<Map<String,String>> list= dataTable.asMaps();

        System.out.println(list.get(0).get("repo_name"));
        System.out.println(list.get(0).get("description"));
        System.out.println(list.get(0).get("private"));

        Response response= GitAPIHelper.createRepository(
                Repository.builder()
                .name(list.get(0).get("repo_name"))
                .description(list.get(0).get("description"))
                .build());
        context.setResponse(response);
        context.setTestData("repositoryName",list.get(0).get("repo_name"));

    }

}
