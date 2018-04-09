package stepdefinitions;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.PageCreator;
import tests.BaseTest;
import tests.HomePageTest;

import java.lang.annotation.Target;

/*
 Class to take care of setting up environment before each scenario is tested.
 */

public class ServiceHooks {

    /*
    METHOD to prepare the test page object using PageCreator class
    CAN create page objects dynamically based on definition.
    FACILITATES the creation of multiple instances of pages in between scenarios
    RETURNs void.
     */
    @Before
    public void initializeTest(){
        // Code to setup initial configurations

        HomePageTest.testPage = new PageCreator(BaseTest.testDriver);

    }

    /*
   METHOD to get screenshots for scenarios. CURRENTLY CONFIGURED TO GRAB SCREENSHOTS FOR ANY TEST. COMMENT THE ELSE BLOCK TO ALLOW SCREENSHOT FOR ONLY FAILED CASES.
   GET screenshot at runtime and attach to report
   RETURNs void.
    */
    @After
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                scenario.embed(((TakesScreenshot)BaseTest.testDriver).getScreenshotAs(OutputType.BYTES),"image/png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //comment this else snippet to have screenshots for FAILED cases only.
        else{
            try {
                scenario.embed(((TakesScreenshot)BaseTest.testDriver).getScreenshotAs(OutputType.BYTES),"image/png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
