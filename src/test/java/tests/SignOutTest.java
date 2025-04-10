package tests;

import base.MainTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CatalogPage;
import pages.LoginPage;

public class SignOutTest extends MainTest {

    @Test
    public void testSignOut(){
        driver.get("https://petstore.octoperf.com/");

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login("trialacc","trialacc");

        CatalogPage catalogPage = new CatalogPage(driver, wait);
        catalogPage.clickSignOut();
        assertTrue(catalogPage.checkWelcomeMessage().equals(""));

    }

}
