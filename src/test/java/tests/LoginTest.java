package tests;

import base.MainTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pages.LoginPage;

public class LoginTest extends MainTest {
    @Test
    public void testValidLogin() throws InterruptedException {

        driver.get("https://petstore.octoperf.com/");
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.login("trialacc","trialacc");
        assertTrue(loginPage.checkWelcomeMessage().contains("Welcome"));
        Thread.sleep(3000);
    }
}
