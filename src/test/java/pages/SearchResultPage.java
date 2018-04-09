package pages;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/*
    Page class for Search Results page
    Used to validate the search results based on search phrase
 */
public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver){
        super(driver);
    }



    //--------WebElement locators-------------

    @FindBy(how=How.ID, using="logo")
    WebElement logoGoogleSearchResultPage;


    // search result list pane
    By searchResultList = By.className("r");

    // link for Maps based on search phrase
    By locatorForLinkMaps = By.linkText("Maps");

    // link for Shopping based on search phrase
    By locatorForLinkShopping = By.linkText("Shopping");

    // link for News based on search phrase
    By locatorForLinkNews = By.linkText("News");

    // link for Alle based on search phrase
    By locatorForAlle = By.linkText("Alle");

    // link for Bilder based on search phrase
    By locatorForBilder = By.linkText("Bilder");

    // link for Mehr based on search phrase
    By locatorForMehr = By.linkText("Mehr");


    /*
    METHOD to grab all web elements corresponding to search results
    RETURNS List of WebElements corresponding to search query
     */
    public List<WebElement> getSearchResultList(){

        this.wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultList));
        return pageDriver.findElements(searchResultList);
    }

    /*
    METHOD to check visibility of search filter Maps on search query
    RETURNs TRUE if visible
     */
    public Boolean isAvailableMapsFilter(){

        return this.isAvailable(locatorForLinkMaps);
    }

    /*
    METHOD to check visibility of search filter Shopping on search query
    RETURNs Boolean flag
     */
    public Boolean isAvailableShoppingFilter(){

        return this.isAvailable(locatorForLinkShopping);
    }

    /*
   METHOD to check visibility of search filter News on search query
   RETURNs Boolean flag
    */
    public Boolean isAvailableNewsFilter(){

        return this.isAvailable(locatorForLinkNews);
    }

    /*
   METHOD to check visibility of search filter Shopping on search query
   RETURNs Boolean flag
    */
    public Boolean isAvailableBilderFilter(){

        return this.isAvailable(locatorForBilder);
    }

    /*
   METHOD to check visibility of search filter Alle on search query
   RETURNs Boolean flag
    */
    public Boolean isAvailableAlleFilter(){

        return this.isAvailable(locatorForAlle);
    }

    /*
   METHOD to check visibility of search filter Shopping on search query
   RETURNs Boolean flag
    */
    public Boolean isAvailableMehrFilter(){

        return this.isAvailable(locatorForMehr);
    }


    /*
   METHOD to flag the availability/visibility of the Search Result section in page.
   RETURNs Boolean value based on the result
   */
    public Boolean areSearchResultsVisible(){

        boolean result = false;

        try{
            WebElement element = pageDriver.findElement(searchResultList);

            if(element.isDisplayed())
                result = true;

        }catch (NoSuchElementException elementNotFound){
            result = false;
        }

        return result;

    }


}
