package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageCreator {

    public WebDriver pageDriver;


    //constructor
    public PageCreator(WebDriver driver){
        this.pageDriver = driver;
    }

    /*
    METHOD to create a new Page object to be tested.
    RETURNs the newly created page
     */
    public <TPage extends BasePage> TPage GetInstance (Class<TPage> pageClass){
        try {
            return PageFactory.initElements(pageDriver,pageClass);
        }catch (Exception e){
            System.out.println("Error initialising elements when instantiating page");
            e.printStackTrace();
            throw e;
        }
    }
}
