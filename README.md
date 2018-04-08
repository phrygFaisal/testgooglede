# Automated Tests For Google.de

This implementation aims to automate 10 specific test scenarios written against google.de site. The scenarios along with the description can be found at the bottom of this document under the section **Test Scenarios**


### Technical Details

#### Automation Stack
* **PAGE OBJECT MODEL** as the framework architecture
* **MAVEN** for build management
* **SELENIUM** as the Driver
* **JAVA** as the Selenium Client
* **TestNG** as the Test Runner
* **CUCUMBER** to cater for BDD com.marketsoft.tests
* **SUREFIRE** plugin for maven for test Reporting.

#### Environment Setup

Set up the environment as per need of usage

* Browser executable need to be available in local directory. The driver should be placed under the project path **BLA BLA BLA**
  * Chrome browser driver for Selenium. Get it [HERE.](https://sites.google.com/a/chromium.org/chromedriver/downloads)
  * Firefox browser driver for Selenium. Get it [HERE.](https://github.com/mozilla/geckodriver/releases)
  * Opera browser driver for Selenium. Get it [HERE.](https://github.com/operasoftware/operachromiumdriver/releases)



###### Runtime Environment

* Maven must be installed. Get it [HERE.](https://maven.apache.org/download.cgi)
* JRE should be installed. Minimum Java version is 7.

###### Development Environment

* Import the repository as maven project.
* Setup Edit Configuration for the RUN.
  * Select Maven Run.
  * for arguments/command line add **package**

* **Java SE 10** 64bit must be installed. Get It [HERE.](http://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html)

Since MAVEN is used as the build tool in the project, most of the dependencies are downloaded as the project is imported in the IDE. Auto Import must be switched to get such advantage. Else the dependencies are resolved during build time.


##### Configuration
* In case of updating any component versions in the maven build, the properties section should be touched. Any version updated will be reflected in the actual component stated under the _**dependencies**_ section.
