Feature: Google.de Homepage

  @FunctionalTest @SmokeTest
  Scenario: Load Google.de site
    When User navigates to homepage
    Then User should see Google Logo

  @FunctionalTest
  Scenario Outline: Autocomplete suggestion on search phrase
    Given User is on Google de site
    When User clicks on search box
    And User types <phrase> in search box
    And User waits for AutoCompleteSuggestion
    Then User should see <output> printed on autocomplete suggestion

    Examples:
    | phrase | output|
    | marketlogic | market |
    | blue + roses |roses |

  @FunctionalTest
  Scenario Outline: Autocomplete suggestion update on search phrase modification
    Given User is on Google de site
    When User clicks on search box
    And User types <phrase> in search box
    And User waits for AutoCompleteSuggestion
    And User deletes <sub-phrase> part of current query
    And User types <new-phrase> in search box
    Then User should see <output> printed on autocomplete suggestion

    Examples:
    |phrase|sub-phrase|new-phrase|output|
    |weather in athens|athens|berlin|weather|
    |dortmund vs real madrid 201|real madrid 201|bayern 201|bayern|

  @FunctionalTest
  Scenario Outline: Search using keyboard RETURN press on search phrase
    Given User is on Google de site
    When User types <phrase> in search box
    And User performs RETURN action using keyboard
    Then User should observe Google Search Result Page with results containing <sub-phrase>

    Examples:
    |phrase| sub-phrase |
    | marketlogic | market |
    | Berlin current weather| weather |
    | restaurants in meiner nähe | restaurants |

  @FunctionalTest
  Scenario Outline: Search using Search button on search phrase
    Given User is on Google de site
    When User types <phrase> in search box
    And User clicks on the Search Button
    Then User should observe Google Search Result Page with results containing <sub-phrase>

  Examples:
  |phrase| sub-phrase |
  | marketlogic | market |

  @FunctionalTest
  Scenario Outline: Search using I'm Feeling lucky button on search phrase
    Given User is on Google de site
    When User types <phrase> in search box
    And User clicks on Feeling lucky button
    Then User should be redirected directly to <url>

    Examples:
    |phrase | url |
    |marketlogic|https://www.marketlogicsoftware.com/|

  @FunctionalTest
  Scenario Outline: Search Phrase does not match any documents on result
    Given User is on Google de site
    When User types <phrase> in search box
    And User performs RETURN action using keyboard
    Then User should be redirected to no results page

    Examples:
      | phrase |
      | 1234452435234324234344 |
      | -------------------------------------------|

  @FunctionalTest
  Scenario: Google Bilder Search Page is loaded
    Given User is on Google de site
    When User clicks on Bilder button
    Then User is redirected to new Google page for Bilder search

  @FunctionalTest
  Scenario: Apps button displays shortcut navigation to Google Applications
    Given User is on Google de site
    When User clicks on Apps button
    Then User is presented with shortcut navigation panel to google applications
    |Mein Konto|
    |Suche|
    |Maps |
    |Youtube|
    |Play   |
    |News   |
    |Gmail  |
    |Drive  |
    |Kalender|
    |Google+ |
    |Fotos   |


  @FunctionalTest
  Scenario: Einstellungen link opens navigation to settings controls
    Given User is on Google de site
    When User clicks on Einstellungen link
    Then User is presented with shortcut links to settings controls