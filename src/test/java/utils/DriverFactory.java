package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

public class DriverFactory {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public static WebDriver initDriver(){
        if(driver == null){
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", new HashMap<String, Boolean>(){{
                put("credentials_enable_service", false);
            }});
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
            quitWait();
        }
    }

    public static WebDriverWait initWait(){
        if (wait == null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
        return wait;
    }

    private static void quitWait(){
        if(wait != null){
            wait = null;
        }
    }
}
