package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    private Driver(){ // Singleton Pattern

    }
    private static WebDriver driver;

    public static WebDriver getDriver(){

        if(driver==null) {
            switch (ConfigReader.getProperty("browser")){

                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                default:
                    driver = new ChromeDriver();
                    break;
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {//if driver is pointing anywhere
            driver.quit();//quit when I call closeDriver
            driver = null;//make the driver null so when we call getDriver, we can open the driver again
        }
    }

}
