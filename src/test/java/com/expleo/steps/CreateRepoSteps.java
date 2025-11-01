package com.expleo.steps;

import com.expleo.context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CreateRepoSteps {
    private final TestContext context;

    public CreateRepoSteps(TestContext context)
    {
        this.context=context;
    }

    @Given("I am an authenticated github user")
    public void i_am_an_authenticated_github_user() {

    }

    @When("I send a request to create a repository with name as {string} and with description {string}")
    public void i_send_a_request_to_create_a_repository_with_name_as_and_with_description(String repoName, String description) {

    }

    @Then("the response code should be {int}")
    public void the_response_code_should_be(Integer expectedStatusCode) {
//        Assert.assertEquals(context.getResponse().statusCode(),expectedStatusCode);
        assertThat("Statuscode check",context.getResponse().getStatusCode(),equalTo(expectedStatusCode));

        //contains id text or not
//        assertThat("Contains id or not",context.getResponse().asString(),containsString("id"));
    }



    @Then("the response should contain the repository name {string}")
    public void the_response_should_contain_the_repository_name(String expectedRepoName) {

    }

    @Then("the response time should be less than {int} milliseconds")
    public void the_response_time_should_be_less_than_milliseconds(Integer expectedResponseTime) {

        assertThat("Response time check",context.getResponse().getTime(),lessThan((long)expectedResponseTime));
    }

    @When("I send a request to update a repository")
    public void i_send_a_request_to_update_a_repository() {

    }
}
