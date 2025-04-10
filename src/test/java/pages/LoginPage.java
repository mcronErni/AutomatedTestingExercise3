package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By enterTheStoreLocator = By.xpath("//a[contains(text(),'Enter the Store')]");
    private By signInButtonLocator = By.xpath("//a[contains(text(),'Sign In')]");
    private By userNameLocator = By.xpath("//input[contains(@name, 'username')]");
    private By passwordLocator = By.xpath("//input[contains(@name, 'password')]");
    private By loginButtonLocator = By.xpath("//input[contains(@name, 'signon')]");
    private By welcomeLocator = By.xpath("//div[contains(@id,'WelcomeContent') and contains(text(),'Welcome')]");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void login(String username, String password) {

        WebElement enterTheStoreBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(enterTheStoreLocator));
        enterTheStoreBtn.click();
        System.out.println("Clicked \"Enter the Store\" Button");

        clickSignInButton();

        enterCredentials(username, password);

        clickLoginBtn();
    }

    public void clickSignInButton(){
        WebElement signInButton = wait.until(ExpectedConditions.visibilityOfElementLocated(signInButtonLocator));
        signInButton.click();
        System.out.println("Clicked \"Sign In\" Button");
    }

    public void enterCredentials(String username, String password){
        setUserName(username);
        setPassword(password);
        System.out.println((String) String.format("Entered\nUsername: %s\nPassword:%s",username,password));
    }
    public void setUserName(String username){
        WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(userNameLocator));
        userNameField.sendKeys(username);
    }

    public void setPassword(String password){
        driver.findElement(passwordLocator).clear();
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void clickLoginBtn() {
        driver.findElement(loginButtonLocator).click();
        System.out.println("Clicked Login Button");
    }

    public String checkWelcomeMessage(){
        WebElement welcome = wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeLocator));
        return welcome.getText();
    }
}

