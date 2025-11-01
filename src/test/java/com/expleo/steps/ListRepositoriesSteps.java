package com.expleo.steps;

import com.expleo.context.TestContext;
import com.expleo.helpers.GitAPIHelper;
import com.expleo.model.Repository;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class ListRepositoriesSteps {

    private final TestContext context;

    public ListRepositoriesSteps(TestContext context)
    {
        this.context=context;
    }

    @When("I send a request to get the list of repostories with OpenAPISpec validation")
    public void i_send_a_request_to_get_the_list_of_repostories_with_open_api_spec_validation() {

       Response response= GitAPIHelper.listRepositoriesForAuthenticatedUser();

       //load the respone to TestContext class object
        context.setResponse(response);

    }

    @Then("each repository should have required fields")
    public void each_repository_should_have_required_fields() {

//        List<Repository> listOfRepo= context.getResponse().as(new TypeRef<List<Repository>>() {});
//or
//        List<Repository> listOfRepo= context.getResponse().jsonPath().getList(".",Repository.class);
//or
        List<Repository> listOfRepo=GitAPIHelper.deserializeResponseToListOfPojoClass(context.getResponse(),Repository.class);
        System.out.println(listOfRepo.size());

        assertThat("All Repo should have id property",listOfRepo,everyItem(hasProperty("id",notNullValue())));
        assertThat("All Repo should have name property",listOfRepo,everyItem(hasProperty("name",not(isEmptyOrNullString()))));
        assertThat("All Repo should have name property",listOfRepo,everyItem(hasProperty("full_name",not(isEmptyOrNullString()))));

        //same like line 43
        for(Repository repo : listOfRepo)
        {
            assertThat("not null",repo.getId(),notNullValue());
        }

//        context.setTestData("repo_name",listOfRepo.get(0).getName());
    }

}
