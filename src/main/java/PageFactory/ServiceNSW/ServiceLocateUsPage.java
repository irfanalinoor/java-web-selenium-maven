package PageFactory.ServiceNSW;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class ServiceLocateUsPage {

    //final variables
    public static final String PAGE_TITLE = "Find a Service NSW location | Service NSW";
    public static final String PAGE_URL = "https://www.service.nsw.gov.au/service-centre";

    //local webdriver variable
    WebDriver driver;

    @FindBy(xpath="/html/body/div[1]/header/div/h1")
    WebElement headingTextLocateUs;

    @FindBy(xpath="//*[@id=\"locatorTextSearch\"]")
    WebElement textFeildSearchBox;

    @FindBy(xpath="//*[@id='locator']/div/div/form/div/div[2]/button")
    WebElement buttonSearch;

    By buttonLocateUs = By.linkText("Locate us");

    By locationListView = By.xpath("//*[@id='locatorListView']");

    By listOfLocationResult = By.xpath("//*[@class='locator__results-list']/div");

    By suggestionLocation = By.xpath("//*[@id=\"locatorAutocomplete\"]");

    //Page Class Constructor
    public ServiceLocateUsPage(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    //Action Methods
    private void InsertSearchText(String searchText){

        textFeildSearchBox.isDisplayed();

        textFeildSearchBox.clear();

        textFeildSearchBox.sendKeys(searchText);
    }

    private void PressSearchButton() {

        try {
            TimeUnit.SECONDS.sleep(10);

            buttonSearch.isDisplayed();

            buttonSearch.click();

        } catch (Exception ex) {

            System.out.println(ex);
        }
    }

    private void SelectSearchText(){

        textFeildSearchBox.sendKeys(Keys.ARROW_DOWN);

        textFeildSearchBox.sendKeys(Keys.ENTER);
    }

    public void StartYourSearch(String searchText){

        InsertSearchText(searchText);

        PressSearchButton();
    }

    public void SelectLocateUs(){

        driver.findElement(buttonLocateUs).isDisplayed();

        driver.findElement(buttonLocateUs).click();
    }

    public boolean IsServiceCenterDisplayed(String serviceCentre) {

        boolean result = false;

        try {
            TimeUnit.SECONDS.sleep(5);

            System.out.println("> No of Location Found = " + driver.findElements(listOfLocationResult).size());

            for (WebElement elementLocation : driver.findElements(listOfLocationResult)) {

                if (elementLocation.findElement(By.xpath(" . //a")).getText().contains(serviceCentre)) {

                    System.out.println(">>> Found " + elementLocation.findElement(By.xpath(" . //a")).getText());

                    result = true;

                }
            }
        } catch (Exception ex) {

            System.out.println(ex);
        }
        return result;
    }
}
