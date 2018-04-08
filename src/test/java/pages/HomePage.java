package pages;


import com.sun.org.apache.xpath.internal.operations.Bool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.BaseTest;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HomePage extends BasePage{

    //constructor
    public HomePage (WebDriver driver) throws IOException {
        super(driver);

    }


    //use common property here LATER
    String baseUrl = "https://www.google.de";/*propertiesManager.getHomepageProperties("homepage_url");*/

    //WebElements read from property LATER
    @FindBy(how=How.ID,using = "hplogo")
    public WebElement logoGoogle;

    @FindBy(how=How.NAME, using = "q")
    public WebElement searchBox;

    @FindBy(how=How.NAME, using = "btnK")
    public WebElement btnGoogleSearch;

    @FindBy(how=How.NAME, using = "btnI")
    public WebElement btnFeelingLucky;

    @FindBy(how = How.LINK_TEXT,using = "Bilder")
    public WebElement linkBilder;

    @FindBy(how=How.CLASS_NAME, using = "gb_Qc")
    public WebElement linkGoogleApps;

    @FindBy(how=How.LINK_TEXT,using = "Einstellungen")
    public WebElement linkEinstellungen;

    @FindBy(how=How.LINK_TEXT,using = "Sucheinstellungen")
    public WebElement linkSuchEinstellungen;

    @FindBy(how=How.LINK_TEXT,using = "Hilfe zur Suche")
    public WebElement linkHilfeZurSuche;

    @FindBy(how=How.LINK_TEXT,using = "Feedback geben")
    public WebElement linkFeedbackGeben;

    @FindBy(how=How.LINK_TEXT,using = "Erweiterte Suche")
    public WebElement linkErweiterteSuche;

    @FindBy(how=How.LINK_TEXT, using = "Protokoll")
    public WebElement linkProtokoll;

    By linkGoogleAppsNavigation = By.className("gb_3");


//    @FindBy
//    @FindBy(how=How.CLASS_NAME,using="sbqs_c")
//    public WebElement searchBoxQueryString;

    By listSearchResult = By.className("sbqs_c");

    //WebElements end here


    //page methods

    /*
    METHOD navigates to the specified URL via the browser under test
    RETURNs void
     */
    public void goToHomepage(){

        pageDriver.get(baseUrl/*propertiesManager.getHomepageProperties(baseUrl)*/);

    }

    /*
    METHOD to write user defined text on the search box
    RETURNs void
     */
    public void writeOnSearchBox(String textToWrite){

        this.writeText(searchBox,textToWrite);
    }

    /*
    METHOD to wait on auto complete search suggestion
    RETURNs void
     */
    public void waitOnSearchSuggestion(){

        this.wait.until(ExpectedConditions.visibilityOfElementLocated(listSearchResult));
    }

    /*
    METHOD to wait on auto complete search suggestion
    RETURNs void
     */
    public void waitOnSearchButtonClickable(){

        this.wait.until(ExpectedConditions.visibilityOf(btnGoogleSearch));
        //this.wait.until(ExpectedConditions.elementToBeClickable(btnGoogleSearch));
    }


    /*
 METHOD to click on the Einstellungen link
 RETURNs void
  */
    public void clickOnEinstellungenLink(){


        this.click(linkEinstellungen);

    }



    /*
   METHOD to click on the search button
   RETURNs void
    */
    public void clickOnSearchBtn(){

        this.waitOnSearchButtonClickable();

        this.click(btnGoogleSearch);
    }

    /*
  METHOD to click on the google Apps link
  RETURNs void
   */
    public void clickOnGoogleAppsLink(){

        if(this.isGoogleAppsLinkVisible())
            this.click(linkGoogleApps);
    }


    /*
  METHOD to click on the bilder button
  RETURNs void
   */
    public void clickOnBilderBtn(){

        this.click(linkBilder);
    }

    /*
    METHOD to click on the feeling lucky button
    RETURNs void
    */
    public void clickOnLuckyBtn(){

        this.click(btnFeelingLucky);
    }

    /*
    METHOD to flag the availability/visibility of the Google Logo in page.
    RETURNs Boolean value based on the result
    */
    public Boolean isGoogleLogoVisible(){

        return this.isAvailable(logoGoogle);

    }

    /*
    METHOD to flag the availability/visibility of the Google Search button in page.
    RETURNs Boolean value based on the result
    */
    public Boolean isGoogleSearchBtnVisible(){

        return this.isAvailable(btnGoogleSearch);

    }

    /*
    METHOD to flag the availability/visibility of the Google Bilder link in page.
    RETURNs Boolean value based on the result
    */
    public Boolean isGoogleBilderLinkVisible(){

        return this.isAvailable(linkBilder);

    }

    /*
    METHOD to flag the availability/visibility of the Google Apps link in page.
    RETURNs Boolean value based on the result
    */
    public Boolean isGoogleAppsLinkVisible(){

        return this.isAvailable(linkGoogleApps);

    }


    /*
    METHOD to flag the availability/visibility of the Google Search Box in page.
    RETURNs Boolean value based on the result
    */
    public Boolean isGoogleSearchBoxVisible(){

        return this.isAvailable(searchBox);

    }

    /*
    METHOD to flag the availability/visibility of the Feeling Lucky button in page.
    RETURNs Boolean value based on the result
    */
    public Boolean isFeelingLuckyBtnVisible(){

        return this.isAvailable(btnFeelingLucky);

    }


    /*
    METHOD to flag the availability/visibility of the Einstellungen link in page.
    RETURNs Boolean value based on the result
    */
    public Boolean isEinstellungenLinkVisible(){

        return this.isAvailable(linkEinstellungen);

    }

    /*
    METHOD to flag the availability/visibility of the link Sucheinstellungen link in page.
    RETURNs Boolean value based on the result
    */
    public Boolean isSucheinstellungenLinkVisible(){

        return this.isAvailable(linkSuchEinstellungen);

    }

    /*
  METHOD to flag the availability/visibility of the link Erweiterte Suchen link in page.
  RETURNs Boolean value based on the result
  */
    public Boolean isErweiterteSuchenLinkVisible(){

        return this.isAvailable(linkErweiterteSuche);

    }

    /*
   METHOD to flag the availability/visibility of the link Protokoll link in page.
   RETURNs Boolean value based on the result
   */
    public Boolean isProtokollLinkVisible(){

        return this.isAvailable(linkProtokoll);

    }

    /*
  METHOD to flag the availability/visibility of the link Hilfe Zur Suche link in page.
  RETURNs Boolean value based on the result
  */
    public Boolean isHilfeZurSucheLinkVisible(){

        return this.isAvailable(linkHilfeZurSuche);

    }

    /*
METHOD to flag the availability/visibility of the link Feedback geben link in page.
RETURNs Boolean value based on the result
*/
    public Boolean isFeedbackGebenLinkVisible(){

        return this.isAvailable(linkFeedbackGeben);

    }

    public List<WebElement> getSearchList(){

        this.isAvailable(listSearchResult);

        return pageDriver.findElements(listSearchResult);

    }

    public List<WebElement> getGoogleAppsNavigationList(){

        this.isAvailable(linkGoogleAppsNavigation);

        return pageDriver.findElements(linkGoogleAppsNavigation);
    }

    public void hitReturnKeyInSearchBox(){

        searchBox.click();

        this.hitReturnKey(searchBox);

    }

    public void hitTabKeyAfterTypingSearchQuery(){

        this.hitTabAKey(searchBox);
    }

    public void hitBackspaceKeyAfterTypingSearchQuery(){

        this.hitBackspaceKey(searchBox);
    }




//    //Go to LoginPage
//    public LoginPage goToLoginPage (){
//        click(signInButton);
//        //I want to chain LoginPage's methods so I return LoginPage by initializing its elements
//        return new PageFactory().initElements(driver,LoginPage.class);
//    }


}
