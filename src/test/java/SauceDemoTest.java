import org.testng.Assert;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import utilities.ScreenshotUtility;
import webpages.CartPage;
import webpages.CheckoutPage;
import webpages.InventoryPage;
import webpages.LoginPage;

public class SauceDemoTest {
    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;
    ExtentReports extent;
    ExtentTest test;

    @BeforeTest
    public void setup() {
        // Setting up ExtentReports with ExtentSparkReporter
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080));
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://www.saucedemo.com/");
    }

    @Test(priority = 1)
    public void login() {
        test = extent.createTest("Login Test");
        try {
            LoginPage loginPage = new LoginPage(page);
            loginPage.login("standard_user", "secret_sauce");
            page.waitForTimeout(3000); // 3 seconds delay for visual validation

            Assert.assertTrue(page.url().contains("inventory.html"));
            test.pass("User logged in successfully!");
        } catch (AssertionError e) {
            ScreenshotUtility.captureScreenshot(page, test); // Capture screenshot on failure

            // Mark test as failed and add the failure message
            test.fail("Login failed: " + e.getMessage());
            throw e; // Rethrow the exception so the test is marked as failed
        }
    }

    @Test(priority = 2)
    public void verifyProductsSortedZToA() {
        test = extent.createTest("Verify Products Sorted Z-A");
        try {
            InventoryPage inventoryPage = new InventoryPage(page);
            inventoryPage.selectSortByZToA();
            page.waitForTimeout(3000);

            boolean isSorted = inventoryPage.isProductsSortedDescending();
            assertTrue(isSorted, "Products are NOT sorted from Z to A!");
            test.pass("Products sorted from Z to A successfully!");
        } catch (AssertionError e) {
            ScreenshotUtility.captureScreenshot(page, test); // Capture screenshot on failure

            // Mark test as failed and add the failure message
            test.fail("Login failed: " + e.getMessage());
            throw e; // Rethrow the exception so the test is marked as failed
        }
    }

    @Test(priority = 3)
    public void verifyPricesSortedHighToLow() {
        test = extent.createTest("Verify Prices Sorted High to Low");
        try {
            InventoryPage inventoryPage = new InventoryPage(page);
            inventoryPage.selectSortByHighToLow();

            boolean isPriceSorted = inventoryPage.isPricesSortedHighToLow();
            assertTrue(isPriceSorted, "Prices are NOT sorted from High to Low!");
            test.pass("Prices sorted from High to Low successfully!");
        } catch (AssertionError e) {
            ScreenshotUtility.captureScreenshot(page, test); // Capture screenshot on failure

            // Mark test as failed and add the failure message
            test.fail("Login failed: " + e.getMessage());
            throw e; // Rethrow the exception so the test is marked as failed
        }
    }

    @Test(priority = 4)
    public void verifyCheckoutJourney() {
        test = extent.createTest("Verify Checkout Journey");
        try {
            InventoryPage inventoryPage = new InventoryPage(page);
            inventoryPage.addHardcodedProductsToCart();

            CartPage cartPage = new CartPage(page);
            cartPage.getCartItemClick();
            cartPage.clickCheckoutButton();

            CheckoutPage checkoutPage = new CheckoutPage(page);
            checkoutPage.fillCheckoutDetails("Rohit", "Mishra", "400104");
            checkoutPage.submitCheckout();
            checkoutPage.finishCheckout();

            assertTrue(checkoutPage.isOrderCompleteVisible(), "Order completion message not visible!");
            test.pass("Checkout journey completed successfully!");
        }

        catch (AssertionError e) {
            ScreenshotUtility.captureScreenshot(page, test); // Capture screenshot on failure
            throw e; // Rethrow the exception to mark the test as failed
        }
    }

    @AfterTest
    public void teardown() {
        // Saving the report
        extent.flush();
        browser.close();
        playwright.close();
    }

}
