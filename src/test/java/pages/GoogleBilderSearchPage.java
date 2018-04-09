package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/*
Page Class for Google Bilder. There are no exclusive functions written for this class since we are only interested to test if the page is loaded properly.
 */
public class GoogleBilderSearchPage extends BasePage{


    //constructor
    public GoogleBilderSearchPage(WebDriver driver) {
        super(driver);
    }

    By bilderLogoLocator = By.className("logo-subtext");



    /*
    METHOD to check visibility of Google Bilder text under the ogo
    RETURNs True if available.
    */
    public Boolean isVisibleBilderLogo(){

        return this.isAvailable(bilderLogoLocator);
    }
}
