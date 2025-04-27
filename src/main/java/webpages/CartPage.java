package webpages;

import com.microsoft.playwright.Page;

public class CartPage {

    private Page page;

    public CartPage(Page page) {
        this.page = page;
    }

    // Method to click on the checkout button
    public void clickCheckoutButton() {
        page.locator("[data-test='checkout']").click();
    }

    // Method to get the count of items in the cart
    public void getCartItemClick() {
        page.locator("[data-test=\"shopping-cart-link\"]").click();
    }

    // Navigate to checkout page (if needed)
    public void goToCheckoutPage() {
        page.locator("[data-test='checkout']").click();
    }
}
