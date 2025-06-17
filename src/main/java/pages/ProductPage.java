package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductPage {
    private Page page;
    //Locators
    private Locator addtocartbtn;
    private static Locator addedprompt;

    public ProductPage(Page page) {
        this.page = page;
        initLocators(); // Initialize all locators here

    }

    private void initLocators() {
        addtocartbtn = page.locator("(//a[@data-product-id= '1'])[1]");
        addedprompt = page.locator("(//p[@class= 'text-center'])[1]");

    }

    //Methods
    public void clickOnTheAddToCartBtn() {
        addtocartbtn.click();

    }
    public static String getAddedText(){
        return addedprompt.textContent();
    }


}



