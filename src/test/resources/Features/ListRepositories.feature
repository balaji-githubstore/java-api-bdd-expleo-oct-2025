@regression   @listRepo
Feature: List Repositories
  In order to collect and manage the exisiting repos
  As a user
  I want to get all repositories details

  @listRepoForUser  @smoke
  Scenario: List all repositories for authenticated user
    Given I am an authenticated github user
    When I send a request to get the list of repostories with OpenAPISpec validation
    Then the response code should be 200
    And the response time should be less than 5000 milliseconds
    And each repository should have required fields


  @listRepoForUser
  Scenario: List all repositories for authenticated user2
    Given I am an authenticated github user
    When I send a request to get the list of repostories with OpenAPISpec validation
    Then the response code should be 200
