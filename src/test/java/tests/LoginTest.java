package tests;

import base.MainTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pages.LoginPage;

public class LoginTest extends MainTest {
    @Test
    public void testValidLogin(){

        driver.get("https://petstore.octoperf.com/");
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login("trialacc","trialacc");
        assertTrue(loginPage.checkWelcomeMessage().contains("Welcome"));
    }
}
