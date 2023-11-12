package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        // Initialize the WebDriver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.daft.ie");
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
