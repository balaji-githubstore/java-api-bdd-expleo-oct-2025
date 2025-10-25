Feature: CreateRepository
  In order to collaborate with project team and track the work
  As a user
  I want to create a remote repository

# create repo
  Scenario: Create valid remote repository
    Given I am an authenticated github user
    When I send a request to create a repository with name as "selenium-gitrepo" and with description "Contains selenium code"
    Then the response code should be 200
    And the response should contain the repository name "selenium-gitrepo"
    And the response time should be less than 5000 milliseconds


  Scenario: Create invalid remote repository
    Given I am an authenticated github user
    When I send a request to create a repository with name as "selenium-gitrepo" and with description "Contains selenium code"
    Then the response code should be 404
    And the response time should be less than 5000 milliseconds




