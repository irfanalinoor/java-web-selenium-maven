package PageFactory.ServiceNSW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.NoSuchElementException;

public class ServiceApplyNumberPlatePage {

    //final variables
    public static final String PAGE_TITLE = "Apply for a number plate | Service NSW";
    public static final String PAGE_URL = "https://www.service.nsw.gov.au/transaction/apply-number-plate";

    //local webdriver variable
    WebDriver driver;

    @FindBy(xpath="//*[@id=\"block-system-main\"]/div/div/div/div[1]/div[3]/div/h1")
    WebElement headingTextApplyForNumbePlate;

    By buttonLocateUs = By.linkText("Locate us");

    By buttonOrderOnline = By.xpath("//a[@href='/node/69081']");

    //Page Class Constructor
    public ServiceApplyNumberPlatePage(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }

    //Action Methods

    public boolean IsApplyNumberPlatePageDiplayed(){
        try{

            headingTextApplyForNumbePlate.isDisplayed();

            if(driver.findElement(buttonOrderOnline).isDisplayed())

                return true;

            else

                return false;

        }catch (NoSuchElementException e ) {

            System.out.println("ERROR > Apply for Number Plate Page is Not Displayed");

            return false;

        }catch (Exception ex){

            return false;

        }
    }

    public void SelectLocateUs(){

        driver.findElement(buttonLocateUs).isDisplayed();

        driver.findElement(buttonLocateUs).click();

    }
}
