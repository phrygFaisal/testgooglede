# Automated Tests For Google.de

This implementation aims to automate 10 specific test scenarios written against google.de site. The scenarios along with the description can be found at the bottom of this document under the section **Test Scenarios**

**NEED TO RENAME HOMEPAGESTEPDEFINITIONS FILE**

### Technical Details

#### Automation Stack
* **PAGE OBJECT MODEL** as the framework architecture
* **MAVEN** for build management
* **SELENIUM** as the Driver
* **JAVA** as the Selenium Client
* **TestNG** as the Test Runner
* **CUCUMBER** for scripting Gherkin tests and Reporting

#### Environment Setup

Implementation has been done with **JDK 10**. Get It [HERE.](http://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html).

**Maven** must be installed. Get it [HERE.](https://maven.apache.org/download.cgi)

**Browser driver** executable need to be available at directory root(**SEE** project structure section below).
  * Chrome browser driver for Selenium. Get it [HERE.](https://sites.google.com/a/chromium.org/chromedriver/downloads)
  * Firefox browser driver for Selenium. Get it [HERE.](https://github.com/mozilla/geckodriver/releases)
  * Opera browser driver for Selenium. Get it [HERE.](https://github.com/operasoftware/operachromiumdriver/releases).
  * Edge browser driver for Selenium. Get it [HERE](https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/#downloads


  (**NOTE:** Current commit supports only Chrome and Firefox browsers. **SEE ADDITIONAL NOTES** section below)




**ADDITIONAL NOTES:** Refer to [**link**](http://pragmatictestlabs.com/2018/01/30/cross-browser-testing-selenium/) for cross-browser Configuration.

##### Running the project using Terminal
* Import the repository from github.
* Ensure the driver executables are present in the project root directory.



* Setup Edit Configuration for the RUN.
  * Select Maven Run.
  * for arguments/command line add **package**


Since MAVEN is used as the build tool in the project, most of the dependencies are downloaded as the project is imported in the IDE. Auto Import must be switched to get such advantage. Else the dependencies are resolved during build time.


##### Configuration
* In case of updating any component versions in the maven build, the properties section should be touched. Any version updated will be reflected in the actual component stated under the _**dependencies**_ section.


##### Test Scenarios
* Load Google.de site
  * Navigates to google.de site and checks if page is loaded. Asserts on the Google logo.


* Autocomplete suggestion on search phrase
  * Checks the text suggested by autocomplete based on search. Uses an acceptance threshold of search suggestions by matching substring. Threshold is defined as 50%.


* Autocomplete suggestion update on search phrase modification
  * Checks the text suggested by autocomplete based on search followed by deleting some phrase and updating at runtime. Uses an acceptance threshold of search suggestions by matching substring. Threshold is defined as 50%.


* Search using keyboard RETURN press on search phrase
  * Checks search functionality on pressing RETURN key from keyboard after typing Search phrase. Asserts on search result page load.


* Search using Search button on search phrase
  * Checks search functionality on pressing RETURN key from keyboard after typing Search phrase. Asserts on search result page load.


* Search using I'm Feeling lucky button on search phrase
  * Checks search functionality on pressing Feeling Lucky button  after typing Search phrase. Asserts on search result page load.


* Search Phrase does not match any documents on result
  * Search with phrase that does not result in any result. Asserts on no search result page load.


* Google Bilder Search Page is loaded
  * Assert on loading Google search for only Bilder.


* Apps button displays shortcut navigation to Google Applications
  * Assert if navigation drawer is opened with Google Apps from google.de page.


* Einstellungen link opens navigation to settings controls
  * Assert if link opens the settings drawer in google.de page
