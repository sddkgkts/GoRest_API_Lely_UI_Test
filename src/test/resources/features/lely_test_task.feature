
Feature: Lely Company Task


  @API_TEST
  Scenario: Test goRest API
    Given As a user I should get all of the data id values are four digit integers and none of them are null
    When As a user I should create a data with given info
    Then As a user I should not crest a data with used info

  @UI_TEST
  Scenario: Selenium Test
    Given As a user I should Navigate to url
    And As a user I should click search button and verify search area appeared.
    When As a user I should enter "happy" into the search area and click the search button
    Then As a user I should verify that the descriptions of each of the search results contain the "happy" word.



  @UI_TEST
  Scenario: Selenium Test2
    Given As a user I should Navigate to url
    And As a user I should navigate to Technical Documents
    When As a user I should select LUNA EUR from the dropdown and verify that the catalogs can be seen
    Then As a user I should view the document and verify that it is opened on a new tab
    And As a user I should return to the previous tab and download the document. Verify that it is downloaded
