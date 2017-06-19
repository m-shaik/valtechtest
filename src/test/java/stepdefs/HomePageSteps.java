package stepdefs;

import cucumber.api.java8.En;
import org.junit.Assert;
import pageobjects.HomePage;

import static common.Driver.driver;

/**
 * Created by Muneer on 19/06/2017.
 */
public class HomePageSteps implements En {

    HomePage homePage = new HomePage();

    public HomePageSteps(){

        Given("^I navigate to valtech home page$", () -> {
           // driver.get("https://www.valtech.com/");
            homePage.navigateToHomePage();
        });

        Then("^Latest news section is displayed$", () -> {
            Assert.assertTrue("Latest News Section is not displayed", homePage.isLatestNewsSectionDisplayed());
        });


        When("^Click on page link (.*)$", (String link) -> {

            try {
                homePage.verifyPageTitle(link);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        });

        Then("^the page title shows correct title$", () -> {

        });

        Given("^I navigate to valtech contact us page$", () -> {
            driver.get("https://www.valtech.com/about/contact-us/");
        });

        Then("^the number of offices are shown$", () -> {
            homePage.displayNumberOfContactOffices();
        });






    }

}
