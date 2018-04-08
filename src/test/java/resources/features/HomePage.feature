Feature: Google.de Homepage

  Scenario: Load Google.de site
    When User navigates to homepage
    Then User should see Google Logo

  Scenario: AutoComplete suggestion based on search
    Given User is on Google de site
    When User clicks on search box
    And User types marketlogic in search box
    And User waits for AutoCompleteSuggestion
    Then User should see marketlogic printed on autocomplete suggestion

  Scenario: Search with keyboard RETURN using Google Search Box
    Given User is on Google de site
    When User types marketlogic in search box
    And User performs RETURN action using keyboard
    Then User should observe Google Search Result Page
#
#
#  Scenario: Search with Search button using Google Search Box
#    Given User is on Google de site
#    When User types Market Logic Software AG in search box
#    And User clicks on Search Button
#    Then User should observe Google Search Result Page


