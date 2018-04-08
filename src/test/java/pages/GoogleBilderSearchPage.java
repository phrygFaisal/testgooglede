package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleBilderSearchPage extends BasePage{

    public GoogleBilderSearchPage(WebDriver driver) {
        super(driver);
    }

    By bilderLogoLocator = By.className("logo-subtext");


    public Boolean isVisibleBilderLogo(){

        return this.isAvailable(bilderLogoLocator);
    }
}
