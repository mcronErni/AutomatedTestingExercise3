package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

public class MainTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/src/test/java/utils/chromedriver.exe");
        driver = DriverFactory.initDriver();
        wait = DriverFactory.initWait();
    }

    @AfterEach
    public void tearDown(){
        DriverFactory.quitDriver();
    }

}
