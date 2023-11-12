package testCases;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.AdPage;
import pageObjects.HomePage;
import pageObjects.SearchResultsPage;


public class DaftSearchTest extends BaseClass{
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private AdPage adPage;

    @BeforeClass
    public void initializePages() {
        Reporter.log("Initializing Page Objects...", true);
        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        adPage = new AdPage(driver);
        homePage.acceptCookiesIfPresent();
        Reporter.log("Page Objects Initialized.", true);
    }


    @Test
    public void searchSaleAdInDublin() throws InterruptedException {
        // Search for a Sale Ad in county Dublin
        Reporter.log("Searching for Sale Ad in Dublin...", true);
        homePage.searchForSaleAd("Dublin");
        Reporter.log("Search Completed.", true);
    }

    @Test(dependsOnMethods = "searchSaleAdInDublin")
    public void verifyURL() {
        Reporter.log("Verifying URL...", true);
        searchResultsPage.verifyUrl();
        Reporter.log("URL Verification Completed.", true);
    }

    @Test(dependsOnMethods = "verifyURL")
    public void applyKeywordFilter() throws InterruptedException {
        Reporter.log("Applying 'garage' keyword filter...", true);
        searchResultsPage.applyKeywordFilter("garage");
        Reporter.log("Filter Applied.", true);
    }


    @Test(dependsOnMethods = "applyKeywordFilter")
    public void verifyKeywordFilterResults() {
        Reporter.log("Verifying Results for Keyword Filter...", true);
        searchResultsPage.verifyResults();
        Reporter.log("Results Verification Completed.", true);
    }

    @Test(dependsOnMethods = "verifyKeywordFilterResults")
    public void openAndVerifyAdvert() throws InterruptedException {
        // Open one search result
        Reporter.log("Opening and Verifying Advertisement...", true);
        searchResultsPage.openFirstResult();
        Reporter.log("Opened result checking ad page", true);
        adPage.verifyPageUrlStartsWith("https://www.daft.ie/for-sale/");
        Reporter.log("Confirmed page checking keyword", true);
        adPage.verifyKeywordVisible("garage");
        Reporter.log("Advertisement Verification Completed.", true);
    }


}

