Feature: Google.de Homepage

  Scenario: Load Google.de site
    When User navigates to homepage
    Then User should see Google Logo

  Scenario: Type on Google Search box
    Given User is on Google de site
    When User clicks on search box
    And User types hallo in search box
    Then User should see hallo printed on the search box
