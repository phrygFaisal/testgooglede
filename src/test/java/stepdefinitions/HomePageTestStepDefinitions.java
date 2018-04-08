package stepdefinitions;



import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.jsoup.Connection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.HomePage;
import pages.PageCreator;
import pages.SearchResultPage;
import tests.BaseTest;
import tests.HomePageTest;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageTestStepDefinitions extends HomePageTest {


    List<WebElement> searchAutoComplete;


    /*
    STEP to fulfil the preliminary requirements of a scenario
    METHOD to facilitate navigation to homepage.
     */
    @Given("^User is on Google de site$")
    public void user_is_on_google_de_site(){

        testPage.GetInstance(HomePage.class).goToHomepage();


    }


    @When("^User navigates to homepage$")
    public void user_navigates_to_homepage()  {
        // Write code here that turns the phrase above into concrete actions
        //testPage = new PageCreator(BaseTest.testDriver);
        testPage.GetInstance(HomePage.class).goToHomepage();
        //throw new PendingException();
    }


    @Then("^User should see Google Logo$")
    public void user_should_see_Google_Logo() {


        assertTrue((testPage.GetInstance(HomePage.class)).isGoogleLogoVisible());
        //throw new PendingException();
    }


    @When("^User clicks on search box$")
    public void user_clicks_on_search_box(){

        if(testPage.GetInstance(HomePage.class).isGoogleSearchBoxVisible())
            testPage.GetInstance(HomePage.class).clickOnSearchBtn();
        else
            assertTrue(Boolean.FALSE);

    }

    @And("^User types (.*) in search box$")
    public void user_types_in_search_box(String userSearchText){

        testPage.GetInstance(HomePage.class).writeOnSearchBox(userSearchText);


    }

    @Then("^User should see (.*) printed on autocomplete suggestion$")
    public void user_should_see_marketlogic_printed_on_the_search_box(String expectedData){

        searchAutoComplete = testPage.GetInstance(HomePage.class).getSearchList();

        for(WebElement searchResult:searchAutoComplete)
            System.out.println(searchResult.getText());

        assertEquals(searchAutoComplete.get(0).getText(),expectedData);

    }


    @And("^User waits for AutoCompleteSuggestion$")
    public void user_waits_for_autocompletesuggestion(){

        testPage.GetInstance(HomePage.class).waitOnSearchSuggestion();

    }


    @And("^User performs RETURN action using keyboard$")
    public void user_performs_return_action_using_keyboard(){

        testPage.GetInstance(HomePage.class).hitReturnKeyInSearchBox();

    }

    @And("^User clicks on the Search Button$")
    public void user_clicks_on_the_search_button(){


        testPage.GetInstance(HomePage.class).hitTabKeyAfterTypingSearchQuery();
        //testPage.GetInstance(HomePage.class).waitOnSearchButtonClickable();
        testPage.GetInstance(HomePage.class).clickOnSearchBtn();

    }

    @Then("^User should observe Google Search Result Page$")
    public void user_should_observe_google_search_result_page(){

        boolean finalResult = false;

        List<WebElement> listOfSearchResults = testPage.GetInstance(SearchResultPage.class).getSearchResultList();

        for(WebElement searchResultTitle : listOfSearchResults) {
            if (searchResultTitle.getText().toLowerCase().matches("market(.*)"))
                finalResult=true;
        }

        assertTrue(finalResult);

    }

    @And ("^User clicks on Feeling lucky button$")
    public void user_clicks_on_feeling_lucky_button(){
        testPage.GetInstance(HomePage.class).hitTabKeyAfterTypingSearchQuery();
        testPage.GetInstance(HomePage.class).clickOnLuckyBtn();
    }

    @Then ("^User should be redirected directly to (.*)$")
    public void user_should_be_redirected_directly_to(String url){

        assertEquals(BaseTest.testDriver.getCurrentUrl(),url);

    }

}
