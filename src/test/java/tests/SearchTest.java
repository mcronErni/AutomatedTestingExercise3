package tests;

import base.MainTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pages.CatalogPage;
import pages.LoginPage;

public class SearchTest extends MainTest {
    @Test
    public void testSearchFunction(){
        driver.get("https://petstore.octoperf.com/");
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login("trialacc","trialacc");

        CatalogPage catalogPage = new CatalogPage(driver, wait);
        catalogPage.searchItem("dog");
        assertTrue(catalogPage.checkSearchResults().equals("Bulldog"));
    }
}
