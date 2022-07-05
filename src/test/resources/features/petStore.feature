@WIP
Feature: Testing petStore API

  Scenario: Positive (CRUD) scenario for petStore API
    Given User Create a new pet on petStore successfully
    When  User Retrieve created pet from petStore successfully
    Then  User Update pets name successfully
    Then  User Delete created pet from petStore successfully

  Scenario: Negative scenario for petStore API
    Given User Retrieve pet from petStore with invalid ID
    Then User Delete pet from petStore with invalid ID




