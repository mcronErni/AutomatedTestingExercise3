package pages;

import base.MainTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogPage extends MainTest {
    private WebDriver driver;
    private WebDriverWait wait;

    public CatalogPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private By catalogLogoLocator = By.xpath("//img[contains(@usemap,'#estoremap')]");
    private By searchFieldLocator = By.xpath("//input[contains(@name,'keyword')]");
    private By searchBtnLocator = By.xpath("//input[contains(@name,'searchProducts')]");
    private By signOutBtnLocator = By.xpath("//a[contains(text(),'Sign Out')]");
    private By welcomeLocator = By.xpath("//div[contains(@id,'WelcomeContent')]");
    private By searchResultsTableLocator = By.xpath("//td[3]");

    public void clickSignOut(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(catalogLogoLocator));
        driver.findElement(signOutBtnLocator).click();
        System.out.println("Clicked Sign Out Button");
    }

    public void searchItem(String productName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(catalogLogoLocator));
        driver.findElement(searchFieldLocator).sendKeys(productName);
        System.out.println("SendKeys: " + productName + " to Search Field");
        driver.findElement(searchBtnLocator).click();
        System.out.println("Clicked Search Button");
    }

    public String checkWelcomeMessage(){
        return driver.findElement(welcomeLocator).getText();
    }

    public String checkSearchResults(){
        WebElement searchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultsTableLocator));
        return searchResult.getText();
    }
}
