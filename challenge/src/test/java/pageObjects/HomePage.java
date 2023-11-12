package pageObjects;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;

    private final WebDriverWait wait;

    // Elements
    @FindBy(id = "didomi-notice-agree-button")
    private WebElement acceptAllCookiesButton;

    @FindBy(id = "search-box-input")
    private WebElement searchInput;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public void acceptCookiesIfPresent() {
        try {
            wait.until(ExpectedConditions.visibilityOf(acceptAllCookiesButton));
            if (acceptAllCookiesButton.isDisplayed()) {
                acceptAllCookiesButton.click();
            }
        } catch (Exception e) {
            System.out.println("Cookie consent banner not present or could not be clicked: " + e.getMessage());
        }
    }

    public void searchForSaleAd(String location) throws InterruptedException {
        searchInput.clear();
        searchInput.sendKeys(location);
        // Wait for the dropdown to become visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid='item']")));
        new Actions(driver).sendKeys(Keys.ENTER).perform();
    }
}
