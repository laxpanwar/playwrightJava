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

    public ProductPage(Page page) {
        this.page = page;
        initLocators(); // Initialize all locators here

    }

    private void initLocators() {
        addtocartbtn = page.locator("//a[@class= 'btn btn-default add-to-cart']");
        addedprompt = page.locator("(//p[@class= 'text-center'])[1]");
        continuebtn = page.locator("//button[@class= 'btn btn-success close-modal btn-block']");

    }

    //Methods
    public void clickOnTheAddToCartBtn() {
        addtocartbtn.click();

    }

    public static String getAddedText() {
        return addedprompt.textContent();
    }

    public void addProductsToAddToCart() {
        //int count = addtocartbtn.count();

        for (int i = 0; i < 3; i++) {
            Locator button = addtocartbtn.nth(i);
            button.scrollIntoViewIfNeeded();
            button.click(new Locator.ClickOptions().setForce(true));
            System.out.println("Confirmation: " + addedprompt.textContent());
            continuebtn.click();
            //page.goBack(); // Navigate back to product list
            //page.waitForLoadState(); // Wait for page to fully load again
        }


    }
}



