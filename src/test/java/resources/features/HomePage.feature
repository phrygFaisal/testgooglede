Feature: Google.de Homepage

  Scenario: Load Google.de site
    When User navigates to homepage
    Then User should see Google Logo

  Scenario: Autocomplete suggestion on search phrase
    Given User is on Google de site
    When User clicks on search box
    And User types marketlogic in search box
    And User waits for AutoCompleteSuggestion
    Then User should see marketlogic printed on autocomplete suggestion

  Scenario: Search using keyboard RETURN press on search phrase
    Given User is on Google de site
    When User types marketlogic in search box
    And User performs RETURN action using keyboard
    Then User should observe Google Search Result Page

  Scenario: Search using Search button on search phrase
    Given User is on Google de site
    When User types marketlogic in search box
    And User clicks on the Search Button
    Then User should observe Google Search Result Page

  Scenario: Search using I'm Feeling lucky button on search phrase
    Given User is on Google de site
    When User types marketlogic in search box
    And User clicks on Feeling lucky button
    Then User should be redirected directly to https://www.marketlogicsoftware.com/


