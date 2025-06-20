package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class ProductPage {
    private Page page;
    //Locators
    private Locator addtocartbtn;
    private static Locator addedprompt;
    private Locator continuebtn;
    private Locator itemsoptions;
    private Locator addtoartoverlay;
    private Locator cartbtn;
    private Locator cartproductlist;

    public ProductPage(Page page) {
        this.page = page;
        initLocators(); // Initialize all locators here

    }

    private void initLocators() {
        addtocartbtn = page.locator("//div[contains(@class, 'productinfo')]//a[contains(@class, 'add-to-cart')]");
        addtoartoverlay= page.locator("//div[contains(@class, 'overlay-content')]//a[contains(@class, 'add-to-cart')]");
        addedprompt = page.locator("(//p[@class= 'text-center'])[1]");
        continuebtn = page.locator("//button[@class= 'btn btn-success close-modal btn-block']");
        itemsoptions = page.locator("//div[@class= 'productinfo text-center']");
        cartbtn= page.locator("(//a[@href='/view_cart'])[1]");
        cartproductlist= page.locator("//td[@class='cart_product']");

    }

    //Methods
    public void clickOnTheAddToCartBtn() {
        addtocartbtn.click();

    }

    public static String getAddedText() {
        return addedprompt.textContent();
    }

    public void addProductsToAddToCart() {
        int total = itemsoptions.count();
        System.out.println(total);
        for (int i = 0; i < itemsoptions.count(); i++) {
            Locator item = itemsoptions.nth(i);
            addtocartbtn.nth(i).hover();
            addtoartoverlay.nth(i).click();
            //System.out.println("Confirmation: " + addedprompt.textContent());
            continuebtn.click();
        }
        page.evaluate("window.scrollTo(0, 0)");
        cartbtn.waitFor(new Locator.WaitForOptions().setTimeout(5000));
        cartbtn.click();
        int totalproduct= cartproductlist.count();
        System.out.println(totalproduct);
        if (total == totalproduct) {
            System.out.println("Product count matches item count.");
        } else {
            System.out.println("Mismatch: Products in cart = " + total + ", Expected = " + totalproduct);
        }

    }

}




