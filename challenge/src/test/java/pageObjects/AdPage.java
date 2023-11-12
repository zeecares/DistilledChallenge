package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AdPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public AdPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Method to check if a given keyword is present in the advertisement content

    public void verifyKeywordVisible(String keyword) {
        // Convert the page source to lowercase
        String pageSource = driver.getPageSource().toLowerCase();
        // Convert the keyword to lowercase for case-insensitive comparison
        String lowerCaseKeyword = keyword.toLowerCase();
        Assert.assertTrue(pageSource.contains(lowerCaseKeyword), "Keyword '" + keyword + "' is not visible on the page.");
    }

    public void verifyPageUrlStartsWith(String urlPrefix) {
        wait.until(ExpectedConditions.urlContains("https://www.daft.ie/for-sale/"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.startsWith(urlPrefix), "Current URL does not start with the expected prefix: " + urlPrefix);
    }

    // Additional methods for other interactions on the advertisement page can be added here
}
