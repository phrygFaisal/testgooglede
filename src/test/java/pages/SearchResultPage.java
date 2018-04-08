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

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver){
        super(driver);
    }



    //Web Element locators.

    @FindBy(how=How.ID, using="logo")
    WebElement logoGoogleSearchResultPage;


    By searchResultList = By.className("r");

    By locatorForLinkMaps = By.linkText("Maps");
    By locatorForLinkShopping = By.linkText("Shopping");
    By locatorForLinkNews = By.linkText("News");
    By locatorForAlle = By.linkText("Alle");
    By locatorForBilder = By.linkText("Bilder");
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
