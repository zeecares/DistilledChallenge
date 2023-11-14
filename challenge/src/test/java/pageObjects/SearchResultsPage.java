package pageObjects;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import java.time.Duration;
import java.util.List;

public class SearchResultsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final Logger logger = Logger.getLogger(SearchResultsPage.class);

    @FindBy(css ="[data-testid^='result-']")
    private List<WebElement> resultElements;
    @FindBy(css = "div[data-testid='title-block'][shub-ins='1']")
    private WebElement FirstResult;
    @FindBy(css = "button[aria-label='Filters']")
    private WebElement FilterButton;

    @FindBy(css = "input[data-testid='terms-input-text']")
    private WebElement keywordSearchInput;

    @FindBy(xpath = "//button[contains(@aria-label, 'Show') and contains(@aria-label, 'results')]")
    private WebElement applyKeywordFilterButton;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public void verifyUrl() {
        wait.until(ExpectedConditions.urlContains("https://www.daft.ie/property-for-sale/dublin"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.daft.ie/property-for-sale/dublin", "URL does not match expected.");
    }

    public void applyKeywordFilter(String keyword) throws InterruptedException {
        FilterButton.click();
        wait.until(ExpectedConditions.visibilityOf(applyKeywordFilterButton));
        //scoll down to keyword search
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", keywordSearchInput);
        keywordSearchInput.clear();
        keywordSearchInput.sendKeys(keyword);
        new Actions(driver).sendKeys(Keys.ENTER).perform();
        applyKeywordFilterButton.click();
        Thread.sleep(2000);
    }


    public void verifyResults() {
        Assert.assertFalse(resultElements.isEmpty(), "No results found.");
    }

    public void openFirstResult() {

        WebElement firstResultElement = resultElements.get(0);
        wait.until(ExpectedConditions.visibilityOf(firstResultElement));

        // Scroll to the first result element
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstResultElement);

        // Find and click the hyperlink inside the result element
        WebElement clickableLink = firstResultElement.findElement(By.cssSelector("a"));
        wait.until(ExpectedConditions.elementToBeClickable(clickableLink));
        clickableLink.click();
    }

}
