package pages;


/*
In this class, we write all common resources.resources.properties.resources.features and attributes of all testable pages.
 */


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends PageCreator {

    //use resources.resources.properties file to fetch this value LATER
    int timeout = 10;

    //constructor
    public BasePage(WebDriver driver){
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(this.pageDriver, timeout);

    /*
    METHOD to facilitate CLICK functionality in the page
    USES By Attribute of the generic property
    PARAMETER input is Generic type property
    RETURNs void against the Generic type.

    NOTE: GENERIC is modelled for WebElement
     */

    public <T> void click(T elementProperty){
        if(elementProperty.getClass().getName().contains("By"))
            pageDriver.findElement((By)elementProperty).click();
        else
            ((WebElement)elementProperty).click();
    }


    /*
    METHOD to facilitate READ TEXT functionality in the page
    USES By Attribute of the generic property
    PARAMETER input is
        Generic type property
    RETURNs String text against the Generic type.

    NOTE: GENERIC is modelled for WebElement
     */

    public <T> String readText(T elementProperty){

        if(elementProperty.getClass().getName().contains("By"))
            return pageDriver.findElement((By)elementProperty).getText();
        else
            return ((WebElement)elementProperty).getText();


    }


    /*
    METHOD to facilitate WRITE TEXT functionality in the page
    USES By Attribute of the generic property
    PARAMETER input is
        Generic type property,
        String text to be written
    RETURNs void against the Generic type.

    NOTE: GENERIC is modelled for WebElement
     */

    public <T> void writeText(T elementProperty, String text){
        if(elementProperty.getClass().getName().contains("By"))
            pageDriver.findElement((By)elementProperty).sendKeys(text);
        else
            ((WebElement)elementProperty).sendKeys(text);
    }

    /*
    METHOD to facilitate identifying the visibility of an item in page
    USES wait on visibility of the item.
    PARAMETER input is
        Generic type property,
    RETURNs void against the Generic type.

    NOTE: GENERIC is modelled for WebElement
     */

    public <T> Boolean isAvailable(T elementProperty){
        if(elementProperty.getClass().getName().contains("By")){

            wait.until(ExpectedConditions.visibilityOfElementLocated((By)elementProperty));
            return pageDriver.findElement((By)elementProperty).isDisplayed();
        }
        else{
            wait.until(ExpectedConditions.visibilityOf((WebElement)elementProperty));
            return ((WebElement)elementProperty).isDisplayed();
        }
    }


     /*
    METHOD to recreate user Keyboard press for RETURN key
    PARAMETER input is
        Generic type property,
    RETURNs void against the Generic type.

    NOTE: GENERIC is modelled for WebElement
     */

    public <T>void hitReturnKey(T elementProperty){
        if(elementProperty.getClass().getName().contains("By"))
            pageDriver.findElement((By)elementProperty).sendKeys(Keys.RETURN);

        else
            ((WebElement)elementProperty).sendKeys(Keys.RETURN);

    }

     /*
    METHOD to recreate user Keyboard press for TAB key
    PARAMETER input is
        Generic type property,
    RETURNs void against the Generic type.

    NOTE: GENERIC is modelled for WebElement
     */

    public <T>void hitTabAKey(T elementProperty){
        if(elementProperty.getClass().getName().contains("By"))
            pageDriver.findElement((By)elementProperty).sendKeys(Keys.TAB);

        else
            ((WebElement)elementProperty).sendKeys(Keys.TAB);

    }






}
