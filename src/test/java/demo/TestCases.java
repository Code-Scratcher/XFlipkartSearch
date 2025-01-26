package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;


// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */
    @Test
    public void testCase01() {
        System.out.println("Test Case 01 : Start");
        try {
            SoftAssert sa = new SoftAssert();

            driver.get("https://www.flipkart.com/");
            Wrappers.loginPopUpClose(driver); // closing ocassionally apearing login popup

            sa.assertTrue(driver.getCurrentUrl().contains("flipkart.com"), "Current page is not flipkart.com");

            String searchInputBoxXpath = "//form[@action='/search']//input[@type='text']";
            WebElement searchInputBox = Wrappers.findWebElement(driver, By.xpath(searchInputBoxXpath), 3, 1);
            Wrappers.sendKeys(driver, By.xpath(searchInputBoxXpath), "Washing Machine");
            searchInputBox.sendKeys(Keys.END);
            searchInputBox.sendKeys(Keys.ENTER);

            String sortByPopularityXpath = "//div[contains(@class,'zg-M3Z') and contains(text(),'Popularity')]";
            Wrappers.clickWebElement(driver, By.xpath(sortByPopularityXpath));
            
            Thread.sleep(5000); // wait for the product raiting to become un-stale

            String productRatingXpath = "//span[contains(@id,'productRating')]";
            System.out.println("Test Case 01 : Checkpoint 1"); // debug statement
            List<WebElement> productRatingWebElements = Wrappers.findWebElementList(driver, By.xpath(productRatingXpath), 3, 1);
            int productCount = 0; // for items less than equal to 4 stars
            for (WebElement productRating : productRatingWebElements) {
                if (Float.parseFloat(productRating.getText())<=4) {
                    productCount ++;
                }
            }
            System.out.println("Product count for products less than 4 stars : "+productCount);


            Thread.sleep(20000);

            sa.assertAll();
        } catch (Exception e) {
            // Log the exception or throw a custom exception
            System.out.println("Exception in TestCase01: " + e.getMessage());
            Assert.fail("Exception in TestCase01: " + e.getMessage());
        }

        System.out.println("Test Case 01 : End");
    }
     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}