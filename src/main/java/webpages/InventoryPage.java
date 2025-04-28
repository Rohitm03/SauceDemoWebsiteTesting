package webpages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class InventoryPage {

    private final Page page;
    private final Locator sortDropdown;
    private final Locator productTitleLinks;

    public InventoryPage(Page page) {
        this.page = page;
        this.sortDropdown = page.locator("[data-test=\"product-sort-container\"]");
        this.productTitleLinks = page.locator(".inventory_container a[id$='_title_link']");
    }

    public void selectSortByZToA() {
        sortDropdown.waitFor();
        sortDropdown.selectOption("za"); // verify value="za" in your HTML
    }

    public boolean isProductsSortedDescending() {
        List<String> actualProductNames = new ArrayList<>();
        int count = productTitleLinks.count();
        for (int i = 0; i < count; i++) {
            actualProductNames.add(productTitleLinks.nth(i).innerText().trim());
        }

        List<String> expectedProductNames = new ArrayList<>(actualProductNames);
        expectedProductNames.sort(Collections.reverseOrder());

        return actualProductNames.equals(expectedProductNames);
    }

    public void selectSortByHighToLow() {
        page.locator("[data-test=\"product-sort-container\"]").selectOption("lohi");
    }

    public boolean isPricesSortedHighToLow() {
        List<String> priceTexts = page.locator(".inventory_item_price").allInnerTexts();
        List<Double> prices = new ArrayList<>();

        for (String priceText : priceTexts) {
            prices.add(Double.parseDouble(priceText.replace("$", "").trim()));
        }

        // Check if the list is sorted descending
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) < prices.get(i + 1)) {
                return false; // Not in descending order
            }
        }
        return true; // All good
    }

    public void addHardcodedProductsToCart() {
        // Hardcode the add-to-cart buttons for specific products
        page.locator("[data-test='add-to-cart-sauce-labs-backpack']").click();
        page.locator("[data-test='add-to-cart-sauce-labs-bike-light']").click();
        page.locator("[data-test='add-to-cart-sauce-labs-fleece-jacket']").click();
        page.locator("[data-test='add-to-cart-test\\.allthethings\\(\\)-t-shirt-\\(red\\)']").click();
    }
}
