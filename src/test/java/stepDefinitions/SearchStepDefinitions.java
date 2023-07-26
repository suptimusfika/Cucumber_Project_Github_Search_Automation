package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import pages.AboutPage;
import pages.HomePage;
import pages.RepositoriesPage;
import setup.BrowserSetup;

public class SearchStepDefinitions extends BrowserSetup {
    HomePage homePage;
    RepositoriesPage repoPage;
    AboutPage aboutPage;
    @Given("user goes to the github website")
    public void user_goes_to_the_github_website() {
        driver.get("https://github.com/");
    }
    @When("user searches for the specific term by name {string}")
    public void user_searches_for_the_specific_term_by_name(String searchOption) {
        homePage = new HomePage(driver);
        homePage.search(searchOption);
    }
    @When("user clicks on Enter button")
    public void user_clicks_on_Enter_button() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.clickEnterButton();
    }
    @Then("user finds and verifies {string} as the first result")
    public void user_finds_and_verifies_as_the_first_result(String searchResult){
        repoPage = new RepositoriesPage(driver);
        repoPage.verifyFirstResult(searchResult);
    }

    @Given("user scrolls down to the page footer")
    public void user_scrolls_down_to_the_page_footer() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

    }

    @When("user clicks on About button")
    public void user_clicks_on_About_button() {
        homePage = new HomePage(driver);
        homePage.clickAboutButton();
    }
    @Then("user is redirected to about page")
    public void user_is_redirected_to_about_page() {
        aboutPage = new AboutPage(driver);
        aboutPage.verifyClickingAboutButtonRedirectsToAboutPage();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
