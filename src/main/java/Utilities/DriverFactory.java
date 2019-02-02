package Utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public enum browserType {
        FIREFOX_WIN,
        CHROME_WIN,
        FIREFOX_MAC,
        CHROME_MAC,
        IE,     //not implemented
        SAFARI  //not implemented
    }
    public static WebDriver getDriver(browserType type){
        WebDriver driver = null;
        String pathOfDrivers = System.getProperty("user.dir")+"/src/main/resource/WebDrivers/";

        switch (type){
            case FIREFOX_MAC:
                System.setProperty("webdriver.gecko.driver", pathOfDrivers+"geckodriver");
                driver = new FirefoxDriver();
                break;
            case CHROME_MAC:
                System.setProperty("webdriver.chrome.driver", pathOfDrivers+"chromedriver");
                driver = new ChromeDriver();
                break;
            case FIREFOX_WIN:
                System.setProperty("webdriver.gecko.driver", pathOfDrivers+"geckodriverWin.exe");
                driver = new FirefoxDriver();
                break;
            case CHROME_WIN:
                System.setProperty("webdriver.chrome.driver", pathOfDrivers+"chromedriverWin.exe");
                driver = new ChromeDriver();
                break;
        }
        return driver;
    }
}
