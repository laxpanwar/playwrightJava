package pages;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {

    private Page page;
    //Locators
    private Locator productBtn;
    private Locator contactusbtn;

    // Constructor
    public HomePage(Page page) {
        this.page = page;
        initLocators(); // Initialize all locators here
    }

    private void initLocators() {
        productBtn = page.locator("//a[@href= '/products']");
        contactusbtn = page.locator("//a[@href= '/contact_us']");


    }

    //Methods
    public ProductPage clickOnTheProductBtn(){
        productBtn.click();
        return new ProductPage(page);
    }

    public ContactUsPage clickontheContactUsBtn(){
        contactusbtn.click();
        return new ContactUsPage(page);
    }
}
