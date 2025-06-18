package pages;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {

    private Page page;
    //Locators
    private Locator productBtn;
    private Locator contactusbtn;
    private Locator testCasebtn;
    private Locator womenCategoryBtn;


    // Constructor
    public HomePage(Page page) {
        this.page = page;
        initLocators(); // Initialize all locators here
    }

    private void initLocators() {
        productBtn = page.locator("//a[@href= '/products']");
        contactusbtn = page.locator("//a[@href= '/contact_us']");
        testCasebtn = page.locator("(//a[@href= '/test_cases'])[1]");
        womenCategoryBtn = page.locator("//a[@href='#Women']");

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

    public TestCasesPage clickontheTestCaseBtn(){
        testCasebtn.click();
        return new TestCasesPage(page);
    }

    public CategoriesPage clickontheWomenBtn(){
        womenCategoryBtn.click();
        return new CategoriesPage(page);
    }

}
