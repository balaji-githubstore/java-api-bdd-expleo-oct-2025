@create  @regression
Feature: CreateRepository
  In order to collaborate with project team and track the work
  As a user
  I want to create a remote repository

  Background:
    Given I am an authenticated github user

# create repo
  @valid
  Scenario Outline: Create valid remote repository
    When I send a request to create a repository with name as "<repo_name>" and with description "<repo_desc>"
    Then the response code should be <expected_response_code>
    And the response should contain the repository name "<repo_name>"
    And the response time should be less than <expected_response_time> milliseconds
    Examples:
      | repo_name       | repo_desc                | expected_response_code | expected_response_time |
      | selenium-repo   | contains selenium code   | 200                    | 5000                   |
#      | playwright-repo | contains playwright code | 200                    | 5000                   |

    @invalid @smoke
  Scenario: Create invalid remote repository
    When I send a request to create a repository with name as "selenium-gitrepo" and with description "Contains selenium code"
    Then the response code should be 404
    And the response time should be less than 5000 milliseconds

      @smoke
  Scenario:
    When I send a request to update a repository
        Then the response code should be 200


