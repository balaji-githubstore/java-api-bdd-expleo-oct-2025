package com.expleo.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Demo1Steps {

    @Given("I am an authenticated github user")
    public void i_am_an_authenticated_github_user() {
        System.out.println("given");
    }
    @When("I send a request to create a repository with name as {string} and with description {string}")
    public void i_send_a_request_to_create_a_repository_with_name_as_and_with_description(String repoName, String description) {
        System.out.println("when"+repoName+description);
    }
    @Then("the response code should be {int}")
    public void the_response_code_should_be(Integer expectedStatusCode)
    {
        System.out.println("then "+expectedStatusCode);
    }



    @Then("the response should contain the repository name {string}")
    public void the_response_should_contain_the_repository_name(String expectedRepoName) {
        System.out.println("then"+expectedRepoName);
    }
    @Then("the response time should be less than {int} milliseconds")
    public void the_response_time_should_be_less_than_milliseconds(Integer expectedResponseTime) {
        System.out.println("then"+expectedResponseTime);
    }

    @When("I send a request to update a repository")
    public void i_send_a_request_to_update_a_repository() {

    }
}
