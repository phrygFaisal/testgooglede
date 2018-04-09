package tests;


import cucumber.api.testng.TestNGCucumberRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.PageCreator;

/*
Base Class for all Test classes

Maintains the Webdriver object for each test class

Supports cross-browser driver instantiation.
 */
public class BaseTest {

    static public WebDriver testDriver;
    static public WebDriverWait wait;

    final int timeout = 10;


    /*
    METHOD to facilitate cross-browser testing.
    Takes parameter input from TestNG. See testng.xml file
    Current testng.xml file only accounts for tests with firefox and chrome. Uncomment the snippets to account for additional browsers respectively. Be sure to add the driver executables under the project root.
     */
    @BeforeClass
    @Parameters("browser")
    public void setUpBeforeClass(String browser) {

        switch (browser){

            case "chrome":
                System.setProperty("webdriver.chrome.driver", "chromedriver");
                testDriver = new ChromeDriver();
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "geckodriver");
                testDriver = new FirefoxDriver();
                break;

                //corresponding test snippet must be added in testng.xml.
            case "opera":

                //add local path to launcherhere
                String pathToOperaLauncher="";

                OperaOptions options = new OperaOptions();
                options.setBinary("operadriver");
                System.setProperty("webdriver.opera.driver", "operadriver.exe");
                options.setBinary(pathToOperaLauncher);
                testDriver = new OperaDriver(options);
                break;

            //corresponding test snippet must be added in testng.xml.
            case "edge":
                System.setProperty("webdriver.edge.driver", "MicrosoftWebDriver.exe");
                testDriver = new InternetExplorerDriver();
                break;

            //corresponding test snippet must be added in testng.xml.
            default:
                System.setProperty("webdriver.chrome.driver","chromedriver");
                testDriver = new ChromeDriver();
                break;
        }

        wait = new WebDriverWait(testDriver,timeout);

        testDriver.manage().window().maximize();

    }


    public WebDriver getTestDriver(){
        return this.testDriver;
    }

    @BeforeMethod
    public void setUpBeforeMethod(){

//        testPage = new PageCreator(testDriver);
    }

    @AfterClass
    public void tearDown(){

        testDriver.quit();
    }

}
