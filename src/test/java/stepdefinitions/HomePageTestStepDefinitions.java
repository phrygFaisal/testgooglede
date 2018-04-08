package stepdefinitions;



import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import pages.GoogleBilderSearchPage;
import pages.HomePage;
import pages.SearchResultPage;
import tests.BaseTest;
import tests.HomePageTest;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class HomePageTestStepDefinitions extends HomePageTest {


    List<WebElement> resultContainer;

    double percentageResultAccuracy = 0.0;
    double acceptanceThreshold = 0.5;

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


    @When("^User clicks on Bilder button$")
    public void user_clicks_on_bilder_button(){

        testPage.GetInstance(HomePage.class).isGoogleBilderLinkVisible();
        testPage.GetInstance(HomePage.class).clickOnBilderBtn();


    }

    @And("^User types (.*) in search box$")
    public void user_types_in_search_box(String userSearchText){

        testPage.GetInstance(HomePage.class).writeOnSearchBox(userSearchText);


    }

    @Then("^User is redirected to new Google page for Bilder search$")
    public void user_is_redirected_to_new_google_page_for_bilder_search(){

        testPage.GetInstance(GoogleBilderSearchPage.class).isVisibleBilderLogo();

    }


    @And("^User deletes (.*) part of current query$")
    public void user_deletes_part_of_current_query(String subQuery){

        int lengthOfSubquery = subQuery.length();

        while(lengthOfSubquery > 0){

            testPage.GetInstance(HomePage.class).hitBackspaceKeyAfterTypingSearchQuery();
            --lengthOfSubquery;
        }



    }

    @Then("^User should see (.*) printed on autocomplete suggestion$")
    public void user_should_see_printed_on_automcomplete_suggestion(String expectedData){

        boolean finalResult = false;

        resultContainer = testPage.GetInstance(HomePage.class).getSearchList();

        double countMatch = 0.0;

        for(WebElement searchResult: resultContainer) {
            System.out.println(searchResult.getText());
            if(searchResult.getText().toLowerCase().contains(expectedData));
                ++countMatch;
            }
            if(resultContainer.size() > 0) {

                percentageResultAccuracy = countMatch / (double) resultContainer.size();

                if(percentageResultAccuracy >= acceptanceThreshold)
                    finalResult = true;
            }

        assertTrue(finalResult);

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

    @Then("^User should observe Google Search Result Page with results containing (.*)$")
    public void user_should_observe_google_search_result_page(String partialResult){

        boolean finalResult = false;
        acceptanceThreshold = 0.5;

        int countMatchResult = 0;

        List<WebElement> listOfSearchResults = testPage.GetInstance(SearchResultPage.class).getSearchResultList();

        for(WebElement searchResultTitle : listOfSearchResults) {
            if (searchResultTitle.getText().toLowerCase().contains(partialResult));

                ++countMatchResult;

        }


        percentageResultAccuracy = countMatchResult/listOfSearchResults.size();

        if( percentageResultAccuracy >= acceptanceThreshold)
            finalResult = true;

        assertTrue(finalResult);

    }

    @Then("^User should be redirected to no results page$")
    public void user_should_redirected_to_no_results_page(){

        assertFalse(testPage.GetInstance(SearchResultPage.class).areSearchResultsVisible());

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

    @When("^User clicks on Apps button$")
    public void user_clicks_on_apps_button(){

       testPage.GetInstance(HomePage.class).clickOnGoogleAppsLink();
    }

    @Then("^User is presented with shortcut navigation panel to google applications$")
    public void user_presented_with_shortcut_navigation_panel_google_apps(DataTable testDataTable){

        List<String> testData = testDataTable.asList(String.class);

        System.out.println("Size of Test Data: "+testData.size());

        boolean resultStatus = false;

        double matchCount = 0;

        resultContainer = testPage.GetInstance(HomePage.class).getGoogleAppsNavigationList();

        System.out.println("Size of Navigation Items: "+ resultContainer.size());

        for(String matchText : testData){
            System.out.println("Match Text" +
                    matchText);

           for(WebElement element:resultContainer){

                if(element.getText().contains(matchText)) {
                    ++matchCount;
                    System.out.println("Found match: "+ element.getText());
                }
           }
        }

        System.out.println("Match Count: " + matchCount);


        if(matchCount/(double) testData.size() >= acceptanceThreshold)
            resultStatus =true;

        assertTrue(resultStatus);


    }

}
