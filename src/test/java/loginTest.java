import org.testng.Assert;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import webpages.CartPage;
import webpages.CheckoutPage;
import webpages.InventoryPage;
import webpages.LoginPage;

public class loginTest {
    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;

    @BeforeTest
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080)); // Set to a large screen size,
                                                                                         // adjust as needed
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://www.saucedemo.com/");
    }

    @Test(priority = 1)
    public void login() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.login("standard_user", "secret_sauce");
        page.waitForTimeout(3000); // 2000 milliseconds = 2 seconds
        Assert.assertTrue(page.url().contains("inventory.html"));
    }

    @Test(priority = 2)
    public void verifyProductsSortedZToA() {
        InventoryPage inventoryPage = new InventoryPage(page);
        inventoryPage.selectSortByZToA();
        page.waitForTimeout(3000); // 2000 milliseconds = 2 seconds
        boolean isSorted = inventoryPage.isProductsSortedDescending();
        assertTrue(isSorted, "Products are NOT sorted from Z to A!");
    }

    @Test(priority = 3)
    public void verifyPricesSortedHighToLow() {
        InventoryPage inventoryPage = new InventoryPage(page);
        inventoryPage.selectSortByHighToLow();

        boolean isPriceSorted = inventoryPage.isPricesSortedHighToLow();
        assertTrue(isPriceSorted, "Prices are NOT sorted from High to Low!");
    }

    @Test(priority = 4)
    public void verifyCheckoutJourney() {
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

    }

    @AfterTest
    public void teardown() {
        browser.close();
        playwright.close();
    }
}