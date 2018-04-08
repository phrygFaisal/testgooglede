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

public class ServiceHooks {

    @Before
    public void initializeTest(){
        // Code to setup initial configurations

        HomePageTest.testPage = new PageCreator(BaseTest.testDriver);

    }

    @After
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                scenario.embed(((TakesScreenshot)BaseTest.testDriver).getScreenshotAs(OutputType.BYTES),"image/png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                scenario.embed(((TakesScreenshot)BaseTest.testDriver).getScreenshotAs(OutputType.BYTES),"image/png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


//        BaseTest.testDriver.quit();
    }
}
