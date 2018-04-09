# Automated Tests For Google.de

This implementation aims to automate 10 specific test scenarios written against google.de site. The scenarios along with the description can be found at the bottom of this document under the section **Test Scenarios**


### Technical Details

#### Automation Stack
* **PAGE OBJECT MODEL** as the framework architecture
* **MAVEN** for build management
* **SELENIUM** as the Driver
* **JAVA** as the Selenium Client
* **TestNG** as the Test Runner
* **CUCUMBER** for scripting Gherkin tests and Reporting

The project is run using Maven build. Maven points to TestNG to run the tests. TestNG prepares the browser driver and points to Cucumber for the running tests against scenarios. The scenarios are present in a feature file which when parsed relates to associated glue code to run the tests. At runtime Cucumber is also configured to report the tests.

**REPORTS** are not attached to the github repository. Please run the project at least once to see the reports. Ther are located under **{project root}/target/cucumber-reports/cucumber-pretty/index.html**. Click on each scenario and expand to see details and attached screenshot.


#### Environment Setup

Implementation has been done with **JDK 10**. Get It [HERE.](http://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html).

**Browser driver** executable need to be available at directory root(**SEE** project structure section below).
  * Chrome browser driver for Selenium. Get it [HERE.](https://sites.google.com/a/chromium.org/chromedriver/downloads)
  * Firefox browser driver for Selenium. Get it [HERE.](https://github.com/mozilla/geckodriver/releases)
  * Opera browser driver for Selenium. Get it [HERE.](https://github.com/operasoftware/operachromiumdriver/releases).
  * Edge browser driver for Selenium. Get it [HERE](https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/#downloads


**Run tests from terminal**

##### Pre-requisite
**Maven** must be installed. Get it [HERE.](https://maven.apache.org/download.cgi)

**Open TERMINAL**, Navigate to project directory and type mvn package to run the tests.

**Development Environment**
* Ensure IDE has plugin support for
  * maven
  * testng


* Import the project as Maven project with auto import on.


##### Configuration
* In case of updating any component versions in the maven build, the properties section should be touched. Any version updated will be reflected in the actual component stated under the _**dependencies**_ section.



  (**NOTE:** Current commit supports only Chrome and Firefox browsers. **SEE ADDITIONAL NOTES** section below)


### Adding a New Test Scenario

Adding a test scenario is simple. Simply use Gherkin syntax for Cucumber and add it in corresponding feature file.

##### With Existing Page

* If the page is already existing, check if there is an existing feature file for it and add scenario there.
* Ensure glue code is present under step definitions-> TestStepDefinition. If not, add the glue code.
* Ensure the existing provides all functionalities to be called from the glue code. If not, implement them.
* AVOID use of XPATH to support cross-browser testing.

##### With New Page

* Create the new page under Pages package.
* Make sure to extend Base Page.
* Implement page functionality using methods, WebElements and locators.
* AVOID use of XPATH to support cross-browser testing.
* Use Base Page methods wherever applicable.
* Add glue code against the new scenarios.



**ADDITIONAL NOTES:**

* Refer to [**link**](http://pragmatictestlabs.com/2018/01/30/cross-browser-testing-selenium/) for cross-browser Configuration.


* Make sure to turn off any auto translation settings for the browser. The implementation only works with google.de site without any translation, else certain scenarios will fail.

##### Test Scenarios

The test Scenarios listed below are implemented for testing. Some of the scenarios are run multiple times with different data sets to ensure coverage(See feature file for detailss).

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
