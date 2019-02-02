package PageFactory.ServiceNSW;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.NoSuchElementException;

public class ServiceHomePage {

    //final variables
    public static final String PAGE_TITLE = "Home | Service NSW";
    public static final String PAGE_URL = "https://www.service.nsw.gov.au/";

    //local webdriver variable
    WebDriver driver;

    @FindBy(xpath="//*[@id=\"edit-contains\"]")
    WebElement textFeildSearchBox;

    @FindBy(xpath="//a[@href='/service-centre']")
    WebElement buttonLocateUs;

    @FindBy(xpath="//*[@id=\"edit-submit-site-search\"]")
    WebElement buttonSearch;

    By linkApplyNumberPlate = By.xpath("//a[@href='/transaction/apply-number-plate']");


    //Page Class Constructor
    public ServiceHomePage(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    //Action Methods
    private void InsertSearchText(String searchText){

        textFeildSearchBox.isDisplayed();

        textFeildSearchBox.clear();

        textFeildSearchBox.sendKeys(searchText);
    }

    private void SelectSearchText(){

        textFeildSearchBox.sendKeys(Keys.ARROW_DOWN);

        textFeildSearchBox.sendKeys(Keys.ENTER);
    }

    private void PressSearchButton(){

        buttonSearch.isDisplayed();

        buttonSearch.click();
    }

    public void StartYourSearch(String searchText){

        InsertSearchText(searchText);

        PressSearchButton();
    }

    public boolean IsLinkApplyNumberPlateDiplayed(){
        try{

            if(driver.findElement(linkApplyNumberPlate).isDisplayed())

                return true;

            else
                return false;

        }catch (NoSuchElementException e ) {

            System.out.println("ERROR > Apply for Number Plate Not Displayed in Search Results ");

            return false;

        }catch (Exception ex){

            return false;
        }
    }

    public void SelectLinkApplyNumberPlate(){

        driver.findElement(linkApplyNumberPlate).click();

    }
    public void SelectLocateUs(){

        buttonLocateUs.isDisplayed();

        buttonLocateUs.click();

    }

}
