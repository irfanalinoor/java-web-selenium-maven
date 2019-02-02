package WebTests;

import Utilities.*;
import PageFactory.ServiceNSW.ServiceHomePage;
import PageFactory.ServiceNSW.ServiceApplyNumberPlatePage;
import PageFactory.ServiceNSW.ServiceLocateUsPage;
import Utilities.DriverFactory;
import Utilities.DriverFactory.browserType;
import com.google.gson.Gson;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import java.io.FileReader;
import java.io.Reader;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServiceTests {

    WebDriver driver;
    browserType type = browserType.CHROME_WIN;
    ServiceHomePage serviceHomePageObj;
    ServiceApplyNumberPlatePage serviceApplyNumberPlatePageObj;
    ServiceLocateUsPage serviceLocateUsPageObj;
    Gson gson = new Gson();
    String pathOfData = System.getProperty("user.dir")+"/src/main/resource/DataFiles/Suburb.json";

    @Before
    public void Setup(){

        driver = DriverFactory.getDriver(type);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        serviceHomePageObj = new ServiceHomePage(driver);

        serviceApplyNumberPlatePageObj = new ServiceApplyNumberPlatePage(driver);

        serviceLocateUsPageObj = new ServiceLocateUsPage(driver);
    }

    @After
    public void TearDown(){

        driver.quit();

    }

//    Case 1
//    Scenario:  Validate that search SHOULD display desired result and navigate to page
//    Given      I have loaded Service NSW website
//    When       I will search for "Apply for a number plate"
//    Then       I will find that search on Service NSW website SHOULD display desired result
//    And        I will find that result link SHOULD navigate to page

    @Test
    public void Case1_VerifySearchResultDisplayed(){

        driver.get(serviceHomePageObj.PAGE_URL);

        assertTrue(driver.getTitle().contains(serviceHomePageObj.PAGE_TITLE));

        serviceHomePageObj.StartYourSearch("Apply for a number plate");

        assertTrue(driver.getTitle().contains("Search Results | Service NSW"));

        assertTrue(serviceHomePageObj.IsLinkApplyNumberPlateDiplayed());

        System.out.println(">>>> Successfully Displayed Apply for a number plate link in Results ");

        serviceHomePageObj.SelectLinkApplyNumberPlate();

        assertTrue(serviceApplyNumberPlatePageObj.IsApplyNumberPlatePageDiplayed());

        assertTrue(driver.getTitle().contains(serviceApplyNumberPlatePageObj.PAGE_TITLE));

        assertTrue(driver.getCurrentUrl().contains(serviceApplyNumberPlatePageObj.PAGE_URL));

        System.out.println(">>>> Successfully Displayed Apply for a number plate Page ");

        driver.close();

    }

//    Case 2
//    Scenario:  Validate that Service Center page SHOULD display location of service centre for given Suburb
//    Given      I have loaded Service Center - Locate US page
//    When       I will search service center for a Suburb
//    Then       I will find that Service Center page SHOULD display location of service centre for given Suburb
//
    @Test
    public void Case2_VerifySuburbServiceCentreDisplayed(){

        driver.get(serviceApplyNumberPlatePageObj.PAGE_URL);

        assertTrue(driver.getTitle().contains(serviceApplyNumberPlatePageObj.PAGE_TITLE));

        serviceApplyNumberPlatePageObj.SelectLocateUs();

        assertTrue(driver.getTitle().contains(serviceLocateUsPageObj.PAGE_TITLE));

        assertTrue(driver.getCurrentUrl().contains(serviceLocateUsPageObj.PAGE_URL));


        try (Reader reader = new FileReader(pathOfData)) {

            //  Convert JSON to Java Object
            SuburbGson suburbGson = gson.fromJson(reader, SuburbGson.class);

            if (suburbGson != null) {

                for (Suburb sub : suburbGson.getSuburb()) {

                    System.out.println("Finding Service Center in "+sub.getSuburbName());

                    driver.navigate().refresh();

                    serviceLocateUsPageObj.StartYourSearch(sub.getSuburbName());

                    assertTrue(serviceLocateUsPageObj.IsServiceCenterDisplayed(sub.getServiceCenter()));

                }
            }
        } catch (IOException e) {

            e.printStackTrace();
        }

        driver.close();
    }
}
