package webpages;

import com.microsoft.playwright.Page;

public class CheckoutPage {

    private Page page;

    // Constructor to initialize the page object
    public CheckoutPage(Page page) {
        this.page = page;
    }

    // Modified method to accept dynamic values for checkout form
    public void fillCheckoutDetails(String firstName, String lastName, String postalCode) {
        page.locator("[data-test='firstName']").fill(firstName);
        page.locator("[data-test='lastName']").fill(lastName);
        page.locator("[data-test='postalCode']").fill(postalCode);
    }

    public void submitCheckout() {
        page.locator("[data-test='continue']").click();
    }

    public void finishCheckout() {
        page.locator("[data-test='finish']").click();
    }

    public boolean isOrderCompleteVisible() {
        return page.locator("[data-test='checkout-complete-container']").isVisible();
    }

}
