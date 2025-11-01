@chain
Feature: CreateRepository
  In order to collaborate with project team and track the work
  As a user
  I want to create,update,get,delete a remote repository

  Background:
#    Given I am an authenticated github user

  @chain1  @directreponame
  Scenario: Create Delete Repo Chain1
    When I create a new repository with name as "apinew-automation12345"
    Then the response code should be 201
    When I delete the same repository for owner "dbala-cloud"
    Then the response code should be 204

  @chain1Example
  Scenario Outline: Create Delete Repo Chain2
    When I create a new repository with name as "<repo_name>"
    Then the response code should be 201
    When I delete the same repository for owner "dbala-cloud"
    Then the response code should be 204
    Examples:
      | repo_name |
      | abd       |
      | demo      |

  @chain2
  Scenario: Create Delete Repo Chain2
    When I create a new repository
      | repo_name | description   | private |
      | abc_1     | contains java | true    |
    Then the response code should be 201
    When I delete the same repository for owner "dbala-cloud"
    Then the response code should be 204


  @chain4
  Scenario Outline: Create Delete Repo Chain4
    When I create a new repository
      | repo_name | description | private   |
      | <name>    | <desc>      | <private> |
    Then the response code should be 201
    When I delete the same repository for owner "dbala-cloud"
    Then the response code should be 204
    Examples:
      | name        | desc   | private |
      | java-repo   | java   | true    |
      | csharp-repo | csharp | false   |
