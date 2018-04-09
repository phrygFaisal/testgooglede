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
