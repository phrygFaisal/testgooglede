package tests;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.PageCreator;


/*
    Test Class for Google.de tests

 */
@CucumberOptions(
        features = "src/test/java/resources/features/HomePage.feature",
        glue = {"stepdefinitions"},
        /*tags = {"~@Ignore"},*/
        tags = {"@FunctionalTest"},
        format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        })
public class HomePageTest extends BaseTest{

        static public PageCreator testPage;


    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeTest
    public void setUp(){

        

        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());

    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {

        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());

    }

    @AfterTest
    public void tearDown(){
        testNGCucumberRunner.finish();
        BaseTest.testDriver.quit();

    }

    @DataProvider
    public Object[][] features() {

        return testNGCucumberRunner.provideFeatures();
    }

//    @AfterClass(alwaysRun = true)
//    public void tearDownClass() throws Exception {
//        testNGCucumberRunner.finish();
//    }


}

