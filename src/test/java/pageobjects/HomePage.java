package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static common.Driver.driver;

/**
 * Created by Muneer on 19/06/2017.
 */
public class HomePage {

    @FindBy(how = How.XPATH, using = "//*[@id='container']/div[2]/div[3]")
    private WebElement LatestNewsSection;

    @FindBy(how = How.XPATH, using = "//*[@id='navigationMenuWrapper']/div/ul/li[1]/a/span")
    private WebElement AboutPageLink;

    @FindBy(how = How.XPATH, using = "//*[@id='navigationMenuWrapper']/div/ul/li[2]/a/span")
    private WebElement WorksPageLink;

    @FindBy(how = How.XPATH, using = "//*[@id='navigationMenuWrapper']/div/ul/li[3]/a/span")
    private WebElement ServicesPageLink;

    @FindBy(how = How.LINK_TEXT, using = "contactcities li a")
    private WebElement ContactOffices;


    public HomePage() {

        PageFactory.initElements(driver, this);
    }

    public boolean isLatestNewsSectionDisplayed() {
        WebElement dynamicElement =
                (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(LatestNewsSection));
        if ((dynamicElement.isDisplayed())) {

            return true;

        } else {
            return false;
        }

    }


    public void verifyPageTitle(String link) {
        String title = "";
        if (link == "About"){
            AboutPageLink.click();
            title =driver.getTitle();
            System.out.println("Page Title is " + title);
            Assert.assertEquals(title.toString(), "About");

            if (link == "Works") {
                WorksPageLink.click();
                title = driver.getTitle();
                Assert.assertEquals(title.toString(), "Works");
            }
                 if (link =="Sercices"){
                ServicesPageLink.click();
                     title =driver.getTitle();
                     Assert.assertEquals(title.toString(), "Services");

                 }
        }

    }

    public void displayNumberOfContactOffices(){

        List<WebElement> numberOfOffices = driver.findElements(By.cssSelector("#container>section div ul  li"));
        System.out.println("Number Of Valtech Offices :" + numberOfOffices.size());
    }
}
